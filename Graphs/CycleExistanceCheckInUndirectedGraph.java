/*
Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

Example 1:

Input:  
V = 5, E = 5
adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
Output: 1


TC:- O(N+2E) ie, for every node we cover its adjacent edges ie, Summazation(adj edged in undirected graph) = degree of graph = 2 * edges.

SC:- O(N) for queue

youtube:- https://www.youtube.com/watch?v=BPlrALf1LDU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14

*/


import java.io.*;
import java.util.*;


class Pair{
    
    public int node;
    public int parent;
    
    public Pair(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}

public class CycleExistanceCheckInUndirectedGraph{
    
    public static boolean checkIfCycleExists(int start, List<List<Integer>> adjList, boolean visited[]){
        
        //Mark the start node as visited
        visited[start] = true;
        
        //Put the node in queue
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,-1));
        
        while(! q.isEmpty()){
            
            //pop element from queue
            int node = q.peek().node;
            int parent = q.peek().parent;
            
            q.remove();
            
            for(int adjNode : adjList.get(node)){
                
                //check if not visited,then add in queue
                if(!visited[adjNode]){
                    visited[adjNode] = true;
                    
                    q.add(new Pair(adjNode, node));
                 
                 
                }else if(adjNode != parent){
                 //If visited , check if its not the immediate parent. 
                 //If not, then there is a cycle where another path has visited the new one before this traversal, 
                 //so return true for existance of cycle  
                 
                   return true;
                }
            }
        }
        
        //no cycle present
        return false; 
    }
    
    
    public static boolean isCycleThere(List<List<Integer>> adjList, int n){
        
        boolean[] visited = new boolean[n];
        
        //common code to check across "connected components" in a given graph
        
        for(int i=0;i<n;i++){
            
            if(!visited[i]){
                
                if(checkIfCycleExists(i,adjList,visited) == true){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    
    public static void main(String[] args){
        
        /*
        {1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}
        
        */
        int n = 5;
        List<List<Integer>> adjList = Arrays.asList(Arrays.asList(1),
                                        Arrays.asList(0,2,4),
                                        Arrays.asList(1,3),
                                        Arrays.asList(2,4),
                                        Arrays.asList(1,3));
        
        
        
        System.out.println("The cycle exists in this graph :" + isCycleThere(adjList,n));
    }
    
}

