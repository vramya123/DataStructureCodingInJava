/*

Problem statement
You are present at point ‘A’ which is the top-left cell of an M X N matrix, your destination is point ‘B’, which is the bottom-right cell of the same matrix. 
Your task is to find the total number of unique paths from point ‘A’ to point ‘B’.In other words, you will be given the dimensions of the matrix as integers ‘M’ and ‘N’, 
your task is to find the total number of unique paths from the cell MATRIX[0][0] to MATRIX['M' - 1]['N' - 1].

To traverse in the matrix, you can either move Right or Down at each step. For example in a given point MATRIX[i] [j], you can move to either MATRIX[i + 1][j] or MATRIX[i][j + 1].

Input :- 3 * 2 matrix

Output :- we are given a 3 x 2 matrix, to move from matrix[0][0] to matrix[2][1] we have the following possible paths.

Path 1 = (0, 0) -> (0, 1) -> (1, 1) -> (2, 1)
Path 2 = (0, 0) -> (1, 0) -> (2, 0) -> (2, 1)
Path 3 =  (0, 0) -> (1, 0) -> (1, 1) -> (2, 1)

Hence a total of 3 paths are available, so the output is 3


Youtube :- 

https://www.youtube.com/watch?v=sdE0A2Oxofw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=10
https://www.youtube.com/watch?v=t_f0nwwdg5o

*/


import java.io.*;
import java.util.*;


public class UniquePathRightDown{
    
    
    //TC : O(2^m*n)  SC: O(path length) = O(m-1 + n-1)
    public static int uniquePathRightDownUsingRecursion(int i, int j){
        
        //base case
        if(i == 0 && j ==0){
            return 1;
        }
        
        if( i < 0 || j < 0){
            return 0;
        }
        
        int up = uniquePathRightDownUsingRecursion(i-1,j);
        int left = uniquePathRightDownUsingRecursion(i,j-1);
        
        return up + left;
    }
    /*
                                                                                          f(3,2)[10]
              
                                                         f(2,2)[6]                                                                            f(3,1)[4]
            
                                      f(1,2)[3]                                 f(2,1)[3]                                        f(2,1)[3]             f(3,0)[1]
                                                                                                                                                   
                           f(0,2)[1]              f(1,1)[2]                f(1,1)[2]       f(2,0)[1]                                             f(2,0)[1]      f(3,-1)  

                    f(-1,2)    f(0,1)[1]        f(0,1)[1]    f(1,0)[1]                 f(1,0)[1]  f(2,-1) 

                            f(-1,1) f(0,0)                f(0,0)  f(1,-1)
                      
                      
    
    
    
    
    */
    //TC : O(N*M)[At max, we can make so many recusrion call]  SC : O(N-1 + M-1) [path  length] + O(N*M)[space for extra matrix]
    public static int uniquePathRightDownUsingMemoization(int i, int j, int[][] dp){
     
        if(i == 0 && j== 0){
            return 1;
        }
        
        if( i < 0 || j < 0){
            return 0;
        }
        
        if( dp[i][j] != -1) 
           return dp[i][j];
        
        int up = uniquePathRightDownUsingMemoization(i-1,j,dp);
        int left = uniquePathRightDownUsingMemoization(i,j-1,dp);
        
        dp[i][j] = up + left;
        
        return dp[i][j];
    }
    
    //TC : O (N*M)  SC: O(N*M)
    public static int uniquePathRightDownUsingTabulation(int n, int m, int[][] dp){
     
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j] = 1;
                }else{
                    int up =0;
                    int left = 0;
                    if(i > 0)
                      up = dp[i-1][j];
                    if(j >0)
                      left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n-1][m-1];
    }
    
    //Tc: O(N*M)  SC: O(N)
     public static int uniquePathRightDownUsingSpaceOptimization(int n, int m){
     
        int[] prev = new int[m];
        for(int i=0;i<n;i++){
            int[] tmp = new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    tmp[j] = 1;
                }else{
                    int up =0;
                    int left = 0;
                    if(i > 0)
                      up = prev[j];
                    if(j >0)
                      left = tmp[j-1];
                    tmp[j] = up + left;
                }
            }
            prev=tmp;
        }
        return prev[m-1];
     }
     
     
     //TC:- O(N)  SC :- O(1)
     public static int uniquePathRightDownUsingCombinations(int n, int m){
         
      //make directions
      int maxDirections = (m-1)+(n-1);
      int r = n-1; //or m-1 ie, right or down directions
      
      int res = 1;
      
      /*
        n= 2  m = 3
        
        maxDirections = n-1 + m-1 = 3
        maxDirections            maxDirections
                 C         or                 C
                 n-1                          m-1
        3                3
         C  = 3/1=3         C   = 2*3/2*1 = 3
          1                 2
                 
      */
      for(int i=1;i<=r;i++){
          res = res * (maxDirections-r+i)/i;
      }
      
      return res;
         
     }
    
    
    public static void main(String[] args){
        
        int n = 4; //0 ,1,2,3 so 4 rows
        
        int m = 3; // 0, 1,2 so 3 columns
        
        System.out.println("The maximum unique path using recursion is "+uniquePathRightDownUsingRecursion(n-1,m-1));
        
        int[][] dp = new int[n][m];
        
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        System.out.println("The maximum unique path using memoization is "+uniquePathRightDownUsingMemoization(n-1,m-1,dp));
        
        System.out.println("The maximum unique path using Tabulation is "+uniquePathRightDownUsingTabulation(n,m,dp));
        
        System.out.println("The maximum unique path using Space Optimization  is "+uniquePathRightDownUsingSpaceOptimization(n,m));
        
         System.out.println("The maximum unique path using Combinations  is "+uniquePathRightDownUsingCombinations(n,m));
        
        
        
    }
}

/*
o/p:-

The maximum unique path using recursion is 10
The maximum unique path using memoization is 10
The maximum unique path using Tabulation is 10
The maximum unique path using Space Optimization  is 10
The maximum unique path using Combinations  is 10
*/
