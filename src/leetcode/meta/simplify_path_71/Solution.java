package leetcode.meta.simplify_path_71;
//solved using trie style data structures
import java.util.*;
class Directory {
    String name;
    Map<String, Directory> subdirectories;
    Directory parent;
    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        subdirectories = new HashMap<>();
    }
}
class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Directory currentDir = new Directory("", null);
        for(String dir : dirs) {
            if(dir.isEmpty() || dir.equals(".")) {
                continue;
            } else if(dir.equals("..")) {
                if(currentDir.parent == null) {
                    continue;
                } else {
                    currentDir = currentDir.parent;
                }
            } else {
                String newPath = currentDir.name + "/" + dir;
                if(!currentDir.subdirectories.containsKey(newPath)) {
                    Directory newDir = new Directory(newPath, currentDir);
                    currentDir.subdirectories.put(newPath, newDir);
                }
                currentDir = currentDir.subdirectories.get(newPath);
            }
         }
        return currentDir.name.isEmpty() ? "/" : currentDir.name;
    }
}
