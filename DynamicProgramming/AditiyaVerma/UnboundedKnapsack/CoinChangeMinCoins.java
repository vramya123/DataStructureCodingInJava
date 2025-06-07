/*

youtube:- https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16

Coin Change Problem Minimum Numbers of coins
Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
Example:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents 


//// Comparision

We have a choice for each element of s[] and we have a capacity of N 

We have below params:-

V    ======>   W
coins[]  ======>   wt[]

Here we can take elements of S[] any number of times, ie, we can repeat so its unbounded knapsack


This is a special problem so we need to initialize two rows , please remember this


*/

import java.io.*;
import java.util.*;


class CoinChangeMinCoins{
    
    
    public int findTheMinCoinsRequiredTogetRequiredSum(int[] coins, int N, int n, int[][] dp){
        
        //initialization
        
        for(int j = 0; j < N+1;j++){
            dp[0][j] = Integer.MAX_VALUE-1; //if given number of coins is 0 and required sum is 0,1,2,.. N, 
                                            //the min no of coins required to make this sum is infinity ie, int.max_val-1
        }
        
        for(int i = 0; i < n+1;i++){
            dp[i][0] = 0; //if given coins is 0,1,2,..n and  sum is 0, min coins required to make sum 0 is 0
        }
        
        for(int j = 1;j<N+1;j++){
            dp[1][j] =  (j%coins[0] == 0)? j/coins[0]: Integer.MAX_VALUE-1;
        }
        
        //choice diagram
        
        for(int i=2;i<n+1;i++){   //note we start i from 2 as i =1 is initialized
            for(int j = 1;j<N+1;j++){
                
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]] +1 , dp[i-1][j]);//we include coins, so add 1
                }else if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][N];
    }
}

public class Solution{
    public static void main(String[] args){
        CoinChangeMinCoins cc = new CoinChangeMinCoins();
        int[]  coins = {25, 10, 5};
        int n = coins.length;
        int N = 30;
        int[][] dp = new int[n+1][N+1];
        
        System.out.println("The min number of coins to get sum is :"+ 
        cc.findTheMinCoinsRequiredTogetRequiredSum(coins,N,n,dp));
    }
}

//o/p:- The min number of coins to get sum is :2
