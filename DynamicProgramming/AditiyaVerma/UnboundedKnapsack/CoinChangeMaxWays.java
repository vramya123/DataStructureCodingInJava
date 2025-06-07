/*


youtube:- https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15


Coin Change Problem Maximum Number of ways

Given a value N, if we want to make change for N cents, 
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change? The order of coins doesn’t matter.

Example:
for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.


///////Comparision why knapsack
We have a choice for each element of s[] and we have a capacity of N 

We have below params:-

N    ======>   W
S[]  ======>   wt[]

Here we can take elements of S[] any number of times, ie, we can repeat so its unbounded knapsack


*/

import java.io.*;
import java.util.*;


class CoinChangeMaxWays{
    
    
    public int findTheMaxWaysWeCanChangeCoinToGetSum(int[] coin, int N, int n, int[][] dp){
        
        //initialization
        for(int j=0;j<N+1;j++){
            dp[0][j] = 0; //0 numbers given and we need to make sum of 0,1,2,3 => 0 
        }
        
        for(int i =0;i<n+1;i++){
            dp[i][0] = 1; //0, 1, ...n numbers are given and we need to make sum of 0 => 1
        }
        
        //choice diagram
        
        for(int i = 1;i < n+1;i++){
            for(int j = 1; j < N+1;j++){
                if(coin[i-1] <= j){
                    dp[i][j] = dp[i][j-coin[i-1]] + dp[i-1][j];
                }else if (coin[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][N];
    }
}

public class Solution{
    public static void main(String[] args){
        CoinChangeMaxWays cc = new CoinChangeMaxWays();
        int[]  coins = {1,2,3};
        int n = coins.length;
        int N = 4;
        int[][] dp = new int[n+1][N+1];
        
        System.out.println("The max number of ways to change coin to get sum is :"+ 
        cc.findTheMaxWaysWeCanChangeCoinToGetSum(coins,N,n,dp));
    }
}

//o/p:- The max number of ways to change coin to get sum is :4
