/* 

01 Knapsack solution
The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible.


youtube:- 
https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=4
https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5
https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=6

*/


import java.io.*;
import java.util.*;

public class Knapsack01{
    
    
    public static int KnapsackUsingMemoization(int[] wt, int[] val,int w,  int n, int[][] dp){
        
        //Base case
        
        if(w == 0 || n==0 )
         return 0;
         
        if(dp[n][w] != -1)
          return dp[n][w];
         
         
        /*
         choice diagram
         
                      wi
               
        wi < w                 wi > w
        
    x               v             x
(don't include) (include)   (don't include)

   */
   
     if( wt[n-1] <= w){
         
         dp[n][w] = Math.max(val[n-1] + KnapsackUsingMemoization(wt,val,w-wt[n-1], n-1,dp), KnapsackUsingMemoization(wt,val,w,n-1,dp));
     }else if (wt[n-1] > w){
         dp[n][w] = KnapsackUsingMemoization(wt, val, w, n-1, dp);
     }
    
      return dp[n][w];
    }
    
    
     public static int KnapsackUsingTabulation(int[] wt, int[] val,int w,  int n, int[][] dp){
         
     
     //Base case => initilaization
     for(int i =0;i<n+1;i++){
       for(int j =0;j<w+1;j++){  
           if(i ==0 || j ==0){
               dp[i][j] = 0;
           }
       }
     }
      
     //choice diagram
     
     for(int i = 1;i<n+1 ;i++){
         for(int j = 1;j<w+1;j++){
             if(wt[i-1] <= j){
                 
                 dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
             }else if (wt[i-1] > j){
                 dp[i][j] = dp[i-1][j];
             }
         }
     }
     
     return dp[n][w];


     }
        
    
    public static void main(String[] args){
        
        int n = 3;
        int w = 4;
        int[] val ={1, 2, 3};
        int[] wt = {4, 5, 1};
        int[][] dp = new int[n+1][w+1];
        
        for(int[] row: dp){
             Arrays.fill(row,-1);
        }
       
        
        System.out.println("The max profit for a knapsack of wt "+ w + 
        " is:"+KnapsackUsingMemoization(wt,val,w,n,dp));
        
        System.out.println("The max profit for a knapsack of wt "+ w + 
        " is:"+KnapsackUsingTabulation(wt,val,w,n,dp));
        
    }
}

//o/p:- The max profit for a knapsack of wt4 is:3
//The max profit for a knapsack of wt 4 is:3
