/*
Dynamic Programming for Fibonacci using below techniques:-

1) Memoization (top down approach)
2) Tabulation (bottom up approach)
3) Space optimization


Youtube:- https://www.youtube.com/watch?v=tyB0ztf0DNY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=9

*/

import java.io.*;
import java.util.*;


public class FibonacciUsingDP{
    
    
    public static int fibonacciUsingMemoization(int n ,int[] dp){
        
        //Base case
        if( n <= 1 ){
            return n;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        return dp[n] = fibonacciUsingMemoization(n-1,dp) + fibonacciUsingMemoization(n-2,dp);
        
        
    }
    
    
    public static int fibonacciUsingTabulation(int n){
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }
    
    
     public static int fibonacciUsingOptimizedSpaceForTabulation(int n){
        
        
        int prev2 = 0;
        int prev = 1;
        
        for(int i=2;i<=n;i++){
           int cur = prev + prev2;
           prev2 = prev;
           prev = cur;
        }
        
        return prev;
        
        /*
        
        Pattern observered for the logic to avoid using an additional array dp
        
        *      *     *      *     *     *     *
      prev2   prev   i
              prev2  prev   i 
                     prev2 prev   i
        
        */
    }
    
    public static void main(String[] args){
        
        int n = 3;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("The fibonnaci of number using memoization for "+ n+" is:"+fibonacciUsingMemoization(n,dp));
        
        //o/p:- The fibonnaci of number using memoization for 3 is:2
        //TC : O(N)  SC : O(N)+ O(N) [stack space plus additional array space]
        
        System.out.println("The fibonnaci of number using tabulation for "+ n+" is:"+fibonacciUsingTabulation(n));
        
        //o/p:- The fibonnaci of number using tabulation for 3 is:2
        //TC : O(N)  SC :  O(N) [additional array space]
        
         System.out.println("The fibonnaci of number using space optimized tabulation for "+ n+" is:"+fibonacciUsingOptimizedSpaceForTabulation(n));
        
        //o/p:- The fibonnaci of number using space optimized  tabulation for 3 is:2
        //TC : O(N)  SC :  O(1) [No additional array space]
        
    }
    
    
    
}
