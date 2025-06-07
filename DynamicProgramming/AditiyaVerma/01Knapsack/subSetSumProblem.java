/* 

Subset Sum Problem 
The task is to return true if we can get a subset whose sum is euql to the once passed by user

youtube:- 
https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7

*/


import java.io.*;
import java.util.*;

public class SubSetSum{
    
    
    public static boolean subSetSumProblem(int[] arr, int n, int sum, boolean[][] dp){
     
     //initialization
     
     for(int i =0;i<n+1;i++){
         for(int j = 0;j<sum+1;j++){
             if(i ==0)
               dp[i][j] = false;
             else if (j ==0)
               dp[i][j] = true; 
         }
     }
        
        
    //choide diagram
    // w -> sum , wt -> arr , val -> x (val is not given, when given one array , just use it as weight array)
    
    for(int i = 1;i<n+1;i++){
        for(int j = 1;j<sum+1 ;j++){
            if(arr[i-1] <= j){
                dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
            }else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    
    return dp[n][sum];
    
    }
        
    
    public static void main(String[] args){
        
        int n = 6;
        int sum = 9;
        int[] arr ={3, 34, 4, 12, 5, 2};
        boolean [][] dp = new boolean [n+1][sum+1];
        
        for(boolean [] row: dp){
             Arrays.fill(row,false);
        }
       
        
        System.out.println("The sub sequence with the given sum  "+ sum  + 
        " is possible:"+subSetSumProblem(arr,n,sum,dp));
        
    }
}

//o/p:- The sub sequence with the given sum  9 is possible:true
