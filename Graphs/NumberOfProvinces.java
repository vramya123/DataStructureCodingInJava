//Number of provinces

//Youtube: https://www.youtube.com/watch?v=ACzkVtewUYA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=8

//TC = O(N) + O(N+2E) ~ O(N) because we traverse upto N nodes in for loop but dfs is done partially for each component which is roughly equal to whole graph


import java.io.*;
import java.util.*;


public class NumberOfProvinces{
    
    public static void dfs(List<List<Integer>> adjList, int start, boolean[] visited){
        
        visited[start] = true;
        
        for(int n: adjList.get(start)){
            if(!visited[n]){
                dfs(adjList,n,visited);
            }
        }
        
    }
    
    public static int numberOfProvincesForAGivenGraph(int[][] adj, int n){
        
        int count = 0;
        
        //Convert adj matrix to list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=1;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adj[i][j] == 1 && i !=j){
                    adjList.get(i).add(j);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        
        //Traverse the visisted array for all vertices
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(adjList,i,visited);
            }
        }
        
        return count;
    }
    //     0
    //   1   2
    
    // 3  
    
    
    public static void main(String[] args){
        
        int[][] adj  = {{0,1,1,0},
               {1,0,0,0},
               {1,0,0,0},
               {0,0,0,0}};
        
        
        int noOfProvinces = numberOfProvincesForAGivenGraph(adj,4);
        
        System.out.println("provinces "+ noOfProvinces);
    }
}

//provinces 2
