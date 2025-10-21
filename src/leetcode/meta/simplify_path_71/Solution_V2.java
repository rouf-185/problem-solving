package leetcode.meta.simplify_path_71;

import java.util.*;

public class Solution_V2 {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque deque = new ArrayDeque<>();
        for(String dir : dirs) {
            if(dir.isEmpty() || dir.equals(".")) {
                continue;
            } else if(dir.equals("..") ) {
                if(!deque.isEmpty()) deque.removeLast();
            } else {
                deque.addLast(dir);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!deque.isEmpty()) {
            sb.append("/" + deque.removeFirst());
        }
        return sb.toString().isEmpty() ? "/" : sb.toString();
    }
}
