

import java.io.*;
import java.util.*;

public class Main {
    
    private static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No filepath has been given. Please mention the file path like this [java Main Data.txt]");
            System.exit(1);
        } else if (args[0].isEmpty()) {
            System.out.println("Enter a valid filepath. Please mention the file path like this [java Main Data.txt]");
            System.exit(1);
        } else if (!fileExists(args[0])) {
            System.out.println("File doesn't exist. Please mention the file path like this [java Main Data.txt]");
            System.exit(1);
        }
        
        String inputFilePath = args[0];
        int startVertex = 0;
        
        if (args.length > 1) {
            try {
                startVertex = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid start vertex. Using default vertex 0.");
            }
        }
        
        Graph graph = new Graph(inputFilePath);
        Fleury fleury = new Fleury(graph);
        fleury.findEulerCircuit(startVertex);
    }
}

class Graph {
    private int[][] matrix;
    
    public Graph(String inputFilePath) {
        List<String> lines = this.getLines(inputFilePath);
        matrix = new int[lines.size()][lines.size()];
        for(int i = 0; i < lines.size(); i++) {
            matrix[i] = this.getArrayFromLine(lines.get(i));
        }
    }
    
    private List<String> getLines(String inputFilePath) {
        List<String> lines = new ArrayList<>();
        File file = new File(inputFilePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
        return lines;
    }
    
    private int[] getArrayFromLine(String line) {
        String[] splitedStrings = line.split("\t");
        String[] itemsString = splitedStrings[1].split(",");
        int[] items = new int[itemsString.length];
        for(int i = 0; i < items.length; i++) {
            items[i] = Integer.parseInt(itemsString[i]);
        }
        return items;
    }
    
    public int getWeight(int u, int v) {
        return matrix[u][v];
    }
    
    public int[] getRow(int u){
        return matrix[u];
    }
    
    public int getSize() {
        return matrix.length;
    }
    
    public boolean hasEdge(int u, int v) {
        return matrix[u][v] > 0;
    }
    
    public void removeEdge(int u, int v) {
        matrix[u][v] = 0;
        matrix[v][u] = 0;
    }
    
    public void addEdge(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }
    
    public Graph copy() {
        Graph copy = new Graph();
        copy.matrix = new int[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                copy.matrix[i][j] = this.matrix[i][j];
            }
        }
        return copy;
    }
    
    private Graph() {}
}

class Fleury {
    private Graph graph;
    
    public Fleury(Graph graph) {
        this.graph = graph;
    }
    
    public void findEulerCircuit(int startVertex) {
        if (!hasEulerCircuit()) {
            System.out.println("No Euler circuit exists in this graph.");
            return;
        }
        
        List<Integer> circuit = new ArrayList<>();
        Graph mutableGraph = graph.copy();
        
        int currentVertex = startVertex;
        circuit.add(currentVertex);
        
        while (hasUnvisitedEdges(mutableGraph)) {
            int nextVertex = chooseNextVertex(mutableGraph, currentVertex);
            if (nextVertex == -1) {
                System.out.println("No valid path found from vertex " + currentVertex);
                break;
            }
            
            mutableGraph.removeEdge(currentVertex, nextVertex);
            circuit.add(nextVertex);
            currentVertex = nextVertex;
        }
        
        outputEulerCircuit(circuit, startVertex);
    }
    
    private boolean hasEulerCircuit() {
        for (int i = 0; i < graph.getSize(); i++) {
            int degree = 0;
            for (int j = 0; j < graph.getSize(); j++) {
                if (graph.hasEdge(i, j)) {
                    degree++;
                }
            }
            if (degree % 2 != 0) {
                return false;
            }
        }
        
        return isConnected();
    }
    
    private boolean isConnected() {
        boolean[] visited = new boolean[graph.getSize()];
        dfs(0, visited);
        
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
    
    private void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int i = 0; i < graph.getSize(); i++) {
            if (graph.hasEdge(vertex, i) && !visited[i]) {
                dfs(i, visited);
            }
        }
    }
    
    private boolean hasUnvisitedEdges(Graph g) {
        for (int i = 0; i < g.getSize(); i++) {
            for (int j = 0; j < g.getSize(); j++) {
                if (g.hasEdge(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private int chooseNextVertex(Graph g, int currentVertex) {
        List<Integer> candidates = new ArrayList<>();
        
        for (int i = 0; i < g.getSize(); i++) {
            if (g.hasEdge(currentVertex, i)) {
                candidates.add(i);
            }
        }
        
        if (candidates.isEmpty()) {
            return -1;
        }
        
        if (candidates.size() == 1) {
            return candidates.get(0);
        }
        
        for (int candidate : candidates) {
            if (isValidEdge(g, currentVertex, candidate)) {
                return candidate;
            }
        }
        
        return candidates.get(0);
    }
    
    private boolean isValidEdge(Graph g, int u, int v) {
        g.removeEdge(u, v);
        
        boolean connected = isConnectedWithPrim(g);
        
        g.addEdge(u, v);
        
        return connected;
    }
    
    private boolean isConnectedWithPrim(Graph g) {
        boolean[] visited = new boolean[g.getSize()];
        int startVertex = 0;
        
        for (int i = 0; i < g.getSize(); i++) {
            for (int j = 0; j < g.getSize(); j++) {
                if (g.hasEdge(i, j)) {
                    startVertex = i;
                    break;
                }
            }
            if (visited[startVertex]) break;
        }
        
        primAlgorithm(g, startVertex, visited);
        
        for (int i = 0; i < g.getSize(); i++) {
            boolean hasEdges = false;
            for (int j = 0; j < g.getSize(); j++) {
                if (g.hasEdge(i, j)) {
                    hasEdges = true;
                    break;
                }
            }
            if (hasEdges && !visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    private void primAlgorithm(Graph g, int startVertex, boolean[] visited) {
        visited[startVertex] = true;
        
        while (true) {
            int minWeight = Integer.MAX_VALUE;
            int nextVertex = -1;
            
            for (int i = 0; i < g.getSize(); i++) {
                if (visited[i]) {
                    for (int j = 0; j < g.getSize(); j++) {
                        if (!visited[j] && g.hasEdge(i, j)) {
                            int weight = g.getWeight(i, j);
                            if (weight < minWeight) {
                                minWeight = weight;
                                nextVertex = j;
                            }
                        }
                    }
                }
            }
            
            if (nextVertex == -1) {
                break;
            }
            
            visited[nextVertex] = true;
        }
    }
    
    private void outputEulerCircuit(List<Integer> circuit, int startVertex) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < circuit.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(circuit.get(i));
        }
        
        sb.append(", ").append(startVertex);
        
        String result = sb.toString();
        System.out.println("Euler Circuit: " + result);
        
        String outputFileName = "euler_circuit_" + startVertex + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write(result);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + outputFileName);
        }
        
        System.out.println("Result saved to: " + outputFileName);
    }
}