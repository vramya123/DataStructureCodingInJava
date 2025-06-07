/* 
Equal Sum Partition

Partition a Set into Two Subsets of Equal Sum

Given an array arr[], the task is to check if it can be partitioned into two parts such that the sum of elements in both parts is the same.
Note: Each element is present in either the first subset or the second subset, but not in both.

Examples: 

Input: arr[] = [1, 5, 11, 5]
Output: true 
Explanation: The array can be partitioned as [1, 5, 5] and [11]


Input: arr[] = [1, 5, 3]
Output: false
Explanation: The array cannot be partitioned into equal sum sets.

youtube:- 
https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8

*/


import java.io.*;
import java.util.*;

public class EqualSumPartition{
    
    public static boolean equalSumPartition(int[] arr,  int n){
        int sum = 0;
        boolean status = false;
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        
        //If sum of array elements is even, only then we can divide to two equal subsetr of same sum
        if(sum%2 !=0 ){
            status = false;
        }else if (sum%2 == 0){
            
             boolean [][] dp = new boolean [n+1][(sum/2)+1];
            for(boolean [] row: dp){
                Arrays.fill(row,false);
            }
       
            status = subSetSumProblem(arr, n, sum/2 ,dp);
        }
        return status;
    }
    
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
        
        int n = 4;
        int[] arr ={1, 5, 11, 5};
       
        
        System.out.println("The equal sum partition is possible:"+equalSumPartition(arr,n));
        
    }
}

//o/p:- The equal sum partition is possible:true
