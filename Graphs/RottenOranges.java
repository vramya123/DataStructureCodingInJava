/*

Rotten oranges

Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.

Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).


Youtube link :- https://www.youtube.com/watch?v=yf3oUhkvqA0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=10


TC : O( N*M) + O(N*M) *4 ~ O(N*M)
SC : O(N*M)


*/


import java.io.*;
import java.util.*;

class Pair{
    int index;
    int time;
    
    public Pair(int index,int time){
        this.index = index;
        this.time = time;
    }
    
    public int getIndex(){
        return index;
    }
    
    public int getTime(){
        return time;
    }
    
}

public class RottenOranges{
    
    public static int findTimeTakenToRottenOrangesInGivenGrid(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        int countFresh = 0;
        
        //Put all initial rotten oranges in queue and compute fresh oranges initially in grid
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i*m+j,0));
                    visited[i][j] = 2;
                }
                if(grid[i][j] == 1)
                   countFresh++;
            }
        }
        
        //Traverse neighbors of rotten oranges
        /*        -1,0
            0,-1   0,0  0,1
                   1,0
        */
        int countRotten = 0;
        int totalTime = 0;
        int[] delRow = {0,-1,0,1};
        int[] delCol = {-1,0,1,0};
        while(! q.isEmpty()){
            Pair p = q.poll();
            int index = p.getIndex();
            int a = index/m;
            int b = index%m;
            int time = p.getTime();
            totalTime = time;
            for(int i=0;i<delRow.length;i++){
                int x = a + delRow[i];
                int y = b + delCol[i];
                if(x >=0 && x < n && y >=0 && y < m && grid[x][y] == 1 && visited[x][y] !=2){
                    q.add(new Pair(x*m+y,time+1));
                    visited[x][y] =2;
                    countRotten++;
                }
            }
        }
        
        //Check if all fresh oranges are rotten
        if(countFresh == countRotten){
            return totalTime;
        }else{
            return -1;
        }
      
    }
    
    
    public static void main(String[] args){
        int[][] grid ={{0,1,2},{0,1,2},{2,1,1}};
        
        int[][] grid2 ={{2,2,0,1}};
        
        System.out.println("The time taken to rotten all oranges in grid is : "+findTimeTakenToRottenOrangesInGivenGrid(grid));
        //The time taken to rotten all oranges in grid is : 1
        
        System.out.println("The time taken to rotten all oranges in grid is : "+findTimeTakenToRottenOrangesInGivenGrid(grid2));
        //The time taken to rotten all oranges in grid is : -1
    }
}
