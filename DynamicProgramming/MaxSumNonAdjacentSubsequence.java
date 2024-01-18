/*

You are given an array/list of ‘N’ integers. You are supposed to return the maximum sum of the subsequence with the constraint that no two elements are adjacent in the given array/list.

Note:
A subsequence of an array/list is obtained by deleting some number of elements (can be zero) from the array/list, leaving the remaining elements in their original order.



Youtube:- https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6

*/


import java.io.*;
import java.util.*;


public class MaxSumNonAdjacentSubsequence{
    
    
    //Memoization
    // TC = O(N)   SC = O(N) + O(N)
    public static int maxSumNonAdjSubsequenceForAGivenArray(int i, int[] a, int[] dp){
        
        //reached i=0 means i=1 was not considered so we can consider i=0, so return a[0]
        if( i == 0)
          return a[0];
          
        if( i < 0)
          return 0;
        
        if(dp[i] != -1)
         return dp[i];
        
        
        //take
        int take = a[i] + maxSumNonAdjSubsequenceForAGivenArray(i-2,a,dp);
        
        //not take
        int noTake = 0 + maxSumNonAdjSubsequenceForAGivenArray(i-1,a,dp);
        
        dp[i] = Math.max(take, noTake);
        
        return dp[i];
          
    }
    
    //Tabulation
    // TC = O(N)   SC = O(N)
    public static int maxSumNonAdjSubsequenceForAGivenArrayUsingTabulation(int[] a, int[] dp){
        
        dp[0] = a[0];
        
        int neg = 0;
        
        for(int i=1;i<a.length;i++){
            
            int take = a[i];
            if(i > 1)
               take += dp[i-2];
            
            int noTake = 0 + dp[i-1];
            
            dp[i] = Math.max(take, noTake);
        }
        
        return dp[a.length-1];
        
    }
    
    /*
    
    .    .     .    .    .
  prev2 prev curi    
        prev2 prev curi 
    
    */
    
    // TC = O(1)   SC = O(N)
    public static int maxSumNonAdjSubsequenceForAGivenArrayWithSpaceOptimization(int[] a){
        
        int prev2 = 0;
        int prev = a[0];
        
        for(int i=1;i< a.length;i++){
            
            int take = a[i] + prev2;
            int noTake = 0 + prev;
            
            int curi = Math.max(take, noTake);
            
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
    
    
    public static void main(String[] args){
        
        int[] a = {2,1,4,9};
        //int[] a = {4};
        int n = a.length-1;
        int[] dp = new int[a.length];
        
        Arrays.fill(dp,-1);
        
        System.out.println("The memoization answer for Max Sum Non Adjacent Subsequence is :"+maxSumNonAdjSubsequenceForAGivenArray(n,a,dp) );
        //The memoization answer for Max Sum Non Adjacent Subsequence is :11
        
        System.out.println("The tabulation answer for Max Sum Non Adjacent Subsequence is :"+maxSumNonAdjSubsequenceForAGivenArrayUsingTabulation(a,dp) );
        //The tabulation answer for Max Sum Non Adjacent Subsequence is :11
        
         System.out.println("The space optimized  answer for Max Sum Non Adjacent Subsequence is :"+maxSumNonAdjSubsequenceForAGivenArrayWithSpaceOptimization(a) );
        //The space optimized answer for Max Sum Non Adjacent Subsequence is :11
    }
    
}
