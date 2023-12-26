//No of islands

//youtube : https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=8

//SC: O(N2)   TC : O(N2) + O(N2 * 9) ~ O(N2)


import java.io.*;
import java.util.*;



public class NoOfIslands{
    
    
    public static int findNoOfIslands(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int noOfIslands = 0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    noOfIslands++;
                    bfs(grid,visited,row,col,i,j);
                }
            }
        }
        return noOfIslands;
        
    }
    
    public static void bfs(int[][] grid, boolean[][] visited, int row, int col, int i, int j ){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(i*col+j);
        visited[i][j] = true;
        
        while(! q.isEmpty()){
            
            int index = q.poll();
            int x = index/col;
            int y = index%col;
            /*
             
            row-1,col-1    row-1,col   row-1,col+1            -1,-1    -1,0    -1,+1     
            row,col-1      row,col     row,col+1               0,-1     0,0     0,+1
            row+1,col-1    row+1,col   row+1,col+1            +1,-1     +1,0    +1,+1 
            
            */
            
            for(int di = -1 ; di <=1 ;di++){
                for(int dj = -1;dj<=1; dj++){
                    int a = x + di;
                    int b = y + dj;
                    if( a >=0 && a < row && b >=0 && b < col && !visited[a][b] && grid[a][b] == 1){
                        visited[a][b] = true;
                        q.add(a*col+b);
                    }
                }
            }
        }
        
    }
    
    public static void main(String[] args){
        int[][] grid = { { 1,1,0,0,0},
                         { 1,0,1,1,0},
                         { 0,0,0,1,0},
                         { 0,1,0,0,0}};
        
        int noOfIslands = findNoOfIslands(grid);
        
        System.out.println("No of Islands is :"+noOfIslands);
    }
}


//o/p:- No of Islands is :2
