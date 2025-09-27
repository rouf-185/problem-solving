import java.io.*;
import java.util.*;

public class Main {
    
    private static boolean fileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
    
    private static List<List<Integer>> getSourceDestPairs(String UCFID) {
        List<List<Integer>> sourceDestPairs = new ArrayList<>();
        for(int i = 1; i < UCFID.length() - 1; i++) {
            int source = Integer.parseInt(UCFID.substring(i - 1, i + 1));
            int destination = Integer.parseInt(UCFID.substring(i, i + 2));
            sourceDestPairs.add(new ArrayList<>(Arrays.asList(source, destination)));
        }
        return sourceDestPairs;
    }

    private static List<List<Integer>> getSourceDestPairsForToy() {
        List<List<Integer>> sourceDestPairs = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                int source = i;
                int destination = j;
                sourceDestPairs.add(new ArrayList<>(Arrays.asList(source, destination)));
            }
        }
        return sourceDestPairs;
    }
    
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("No filepath has been given. Please mention the file path like this [java Main Toy.txt]");
            System.exit(1);
        } else if(args[0].isEmpty()) {
            System.out.println("Enter a valid filepath. Please mention the file path like this [java Main Toy.txt]");
            System.exit(1);
        } else if (!fileExist(args[0])) {
            System.out.println("File doesn't exist. Please mention the file path like this [java Main Toy.txt]");
            System.exit(1);
        }
        String inputFilePath = args[0];
        Graph graph = new Graph(inputFilePath);
        String UCFID = !args[0].contains("Toy.txt") ? args[1] : "";
        List<List<Integer>> sourceDestPairs = args[0].contains("Toy.txt") ? getSourceDestPairsForToy() : getSourceDestPairs(UCFID);
        Dijkstra dijk = new Dijkstra(graph, sourceDestPairs);
        dijk.run();
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
}

class Pair implements Comparable<Pair>{
    private int node;
    private int distance;
    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
    public void setNode(int node) {
        this.node = node;
    }
    public int getNode() {
        return this.node;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getDistance() {
        return this.distance;
    }
    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.distance, other.distance);
    }
}

class Dijkstra {
    private Graph graph;
    private List<List<Integer>> sourceDestinationPairs;
    public Dijkstra(Graph graph, List<List<Integer>> sourceDestinationPairs) {
        this.graph = graph;
        this.sourceDestinationPairs = sourceDestinationPairs;
    }
    public void run() {
        Map<Integer, List<Map<Integer, Integer>>> results = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(List<Integer> sourceDestinationPair : this.sourceDestinationPairs) {
            int destination = sourceDestinationPair.get(1);
            int source = sourceDestinationPair.get(0);
            if(!results.containsKey(destination)) {
                results.put(destination, calculateShortestPath(destination));
            }
            String resultString = "Distance from " + source + " to " + destination + " equals " +  results.get(destination).get(0).get(source) + " unit(s)\n";
            resultString += "Path: ";
            int x = source;
            //print path
            while(x != results.get(destination).get(1).get(x)) {
                resultString += x + " -> ";
                x = results.get(destination).get(1).get(x);
            }
            resultString += destination + "\n";
            String outputFileName = source + "_" + destination + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                writer.write(resultString);
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + outputFileName);
            }
        }
        System.out.println(sb.toString());
    }
    public List<Map<Integer, Integer>> calculateShortestPath(int destination) {
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> paths = new HashMap<>();
        for(int i = 0; i < graph.getSize(); i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(destination, 0);
        paths.put(destination, destination);
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(destination, 0));
        while(!pq.isEmpty()) {
            int v = pq.poll().getNode();
            visited.add(v);
            for(int u = 0; u < graph.getSize(); u++) {
                int weight = graph.getWeight(v, u);
                if (weight > 0 && !visited.contains(u) && distances.get(v) + weight < distances.get(u)) {
                    distances.put(u, distances.get(v) + weight);
                    pq.offer(new Pair(u, distances.get(u)));
                    paths.put(u, v);
                }
            }
        }
        return new ArrayList<>(Arrays.asList(distances, paths));
    }

}