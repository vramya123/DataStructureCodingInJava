//BFS traversal

//Youtube :- https://www.youtube.com/watch?v=-tgVpUgsQ5k&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=6

//TC : O(N) + O(2E) (traversal of all elements in queue and for each element, we traver the neighbors of it which is nothing but degree of that node ie, total degree = 2 times of edges in a graph)


import java.io.*;
import java.util.*;


public class BFSTraversal{
    
    public static List<Integer> bfsTraversalOfGivenGraph(List<List<Integer>> graph){
        
        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()]; 
        
        q.add(0);
        visited[0] = true;
        
        while(! q.isEmpty()){
            Integer first = q.poll();
            bfs.add(first);
               
            for(Integer  n : graph.get(first)){
                if(!visited[n]){
                    q.add(n);
                    visited[n] = true;
                }
            }
            
        }
        
        return bfs;
    }
    //     0
    //  1     2
    // 4  5     6
    //       7     3
    public static void main(String[] args){
        
        List<List<Integer>> graph = new ArrayList<>();
        
        graph.add(Arrays.asList(1,2));
        graph.add(Arrays.asList(0,5,4));
        graph.add(Arrays.asList(0,5,6));
        graph.add(Arrays.asList(6));
        graph.add(Arrays.asList(1));
        graph.add(Arrays.asList(1,7));
        graph.add(Arrays.asList(2,7,3));
        graph.add(Arrays.asList(6));
        
        List<Integer> bfs = bfsTraversalOfGivenGraph(graph);
        
        bfs.forEach(System.out::print);
        
    }
    
}

//op : 01254673
