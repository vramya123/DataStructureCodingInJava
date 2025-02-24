/*


DFS Traversal from teh given node

Youtube Link :- https://www.youtube.com/watch?v=Qzf1a--rhp8


Sc :- O(n) + O(n) + o(n) = O(n) [ n does are saved to traver, n sized visisted array , stack of size n ] [Note this does not include the adjacency list size]

TC:- O(n) + O(2E)  (traversal of all elements in stack and for each element, we traver the neighbors of it which is nothing but degree of that node ie, total degree = 2 times of edges in a graph)

*/

import java.io.*;
import java.util.*;

public class DFSTraversal{
    
    
    public static void dfsTraversal(int node, boolean[] visited, List<List<Integer>> graph, List<Integer> dfs){
        
        //mark the node as visisted and add in dfs path tracking list
        visited[node] = true;
        dfs.add(node);
        
        //For each neighbor do the depth traversal
        for(Integer n : graph.get(node)){
            //Before traversing check if not visited
            if(!visited[n]){
                dfsTraversal(n,visited,graph,dfs);
            }
        }
    }
    
    public static void main(String[] args){
        /*
            1_ 3 _ 5
            |  |   |
            2- 4   6
        
        
        */
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(0));
        graph.add(Arrays.asList(2,3));
        graph.add(Arrays.asList(1,4));
        graph.add(Arrays.asList(1,4,5));
        graph.add(Arrays.asList(2,3));
        graph.add(Arrays.asList(3,6));
        graph.add(Arrays.asList(5));
        
        boolean[] visited = new boolean[graph.size()+1]; 
        visited[0]= true;
        List<Integer> dfs = new ArrayList<>();
       
        
        dfsTraversal(1,visited,graph,dfs);
        
        dfs.forEach(System.out::println);
    }
    
}

/* o/p:-

1
2
4
3
5
6
*/
