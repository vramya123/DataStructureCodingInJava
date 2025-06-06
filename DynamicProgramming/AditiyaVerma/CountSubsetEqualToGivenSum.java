/* 
Count subset sum equal to given sum

Count of subsets sum with a Given sum
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
Example:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3}

Note:- All numbers must be positive here 

youtube:- 
https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9

*/


import java.io.*;
import java.util.*;

public class CountSubsetEqualToGivenSum{
    
    public static int subSetSumCountProblem(int[] arr, int n, int sum, int[][] dp){
     
     //initialization
     
     for (int j = 0; j < sum + 1; j++) {
             dp[0][j] = 0; 
     }
     
     for (int i = 0; i < n + 1; i++) {
             dp[i][0] = 1; // There's always one way to get sum 0 (by taking an empty subset)
     } 
     
      
        
        
    //choice diagram
    // w -> sum , wt -> arr , val -> x (val is not given, when given one array , just use it as weight array)
    
    for(int i = 1;i<n+1;i++){
        for(int j = 1;j<sum+1 ;j++){
            if(arr[i-1] <= j){
                dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]] ;
            }else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    
    return dp[n][sum];
    
    }
        
    
    public static void main(String[] args){
        
        int n = 4;
        int[] arr ={1, 2, 3, 3};
        int sum = 6;
        int[][] dp = new int[n+1][sum+1];
        
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        
        System.out.println("The count of subsets equal to given sum is:"+subSetSumCountProblem(arr,n,sum,dp));
        
    }
}

//The count of subsets equal to given sum is:3
