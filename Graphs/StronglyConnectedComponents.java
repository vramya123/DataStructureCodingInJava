/*

Strongly Connected Components - Kosaraju's Algorithm

Find teh number of strongly connected components in a given directed graph :-
In a strongly connected component, we can reach every node from every other node 


Youtube Link :- https://www.youtube.com/watch?v=R6uoSjZ2imo

TC = O(E+V)  SC  = O(V)
*/

import java.io.*;
import java .util.*;

public class StronglyConnectedComponents{
    
    
    private static void dfs(int node,List<List<Integer>> adjList, int[] vis, Stack<Integer> st ){
        
        vis[node] = 1;
        for(Integer n : adjList.get(node)){
            if( vis[n] == 0){
                 dfs(n,adjList,vis,st);
            }
        }
        st.push(node);
    }
    
      
    private static void dfs3(int node,List<List<Integer>> adjList, int[] vis ){
        
        vis[node] = 1;
        for(Integer n : adjList.get(node)){
            if(vis[n] == 0){
                 dfs3(n,adjList,vis);
            }
        }
    }
    
    private static int numberOfStronglyConnectedComponents(List<List<Integer>> adjList,int n){
        
        //Store nodes in the order of their finish point
        
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i =0;i < n;i++){
            if(vis[i] == 0){
                dfs(i,adjList, vis,st);
            }
        }
        
        //Transpose the graph to isolate the strongly connected components
        
        List<List<Integer>> adjListT = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjListT.add(new ArrayList<>());
        }
        
        for(int i = 0;i<vis.length;i++){
            vis[i] =0;
            for(Integer ng : adjList.get(i)){
              //i -> n is der, we need to make n->i
             adjListT.get(ng).add(i);
            }
        }
        
        
        //Perform dfs from the first node to get the number of SCC
        int noOfSCC = 0;
        
        while(!st.isEmpty()){
            Integer num = st.peek();
            st.pop();
            if(vis[num] == 0){
                noOfSCC++;
                dfs3(num,adjListT,vis);
            }
        }
        
        return noOfSCC;
        
    }
    
    public static void main(String[] args){
        
        
        /*
                  0
            /^    |>     \>
        1     <-  2      3
                        |>
                         4
        
        */
        
        List<List<Integer>> adjList = new ArrayList<>();
        int n = 5;
        
        adjList.add(Arrays.asList(2,3));
        adjList.add(Arrays.asList(0));
        adjList.add(Arrays.asList(1));
        adjList.add(Arrays.asList(4));
        adjList.add(new ArrayList<>());
        
        
        System.out.println("The no: of SCC is "+ numberOfStronglyConnectedComponents(adjList,n));
        
    }
}

//o/p:-  The no: of SCC is 3
