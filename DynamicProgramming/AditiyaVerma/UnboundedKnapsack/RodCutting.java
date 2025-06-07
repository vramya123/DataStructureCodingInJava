/*
youtube :- https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15

Rod Cutting 


Given a rod of length n inches and an array price[]. price[i] denotes the value of a piece of length i. The task is to determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: price[] is 1-indexed array.

Input: price[] =  [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation:  The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.

Input : price[] =  [3, 5, 8, 9, 10, 17, 17, 20]
Output : 24
Explanation : The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1]= 8*3 = 24.

Input : price[] =  [3]
Output : 3
Explanation: There is only 1 way to pick a piece of length 1.


Note:-----------


As sizes can be repeated, this is unbounded knapsack.

In unbounded knapsack, once an item is selected, it can be selected again . 
However if it is not selected once, then it is not selected again at all.

unbounded    =====> 0/1 knapsack
w            =====> N
price       ======> value
length      ======> weight


*/


import java.io.*;
import java.util.*;
import java.util.stream.*;

class RodCutting{
    
    
    public int findTheMaxProfitForCuttingTheRod(int[] price, int[] len , int n, int N, int[][] dp){
        
        //initilaization
        for(int j =0;j< N+1;j++){
            dp[0][j] = 0;
        }
        
        for(int i = 0;i < n+1;i++){
            dp[i][0] = 0;
        }
        
        
        //choice diagram
        
        for(int i = 1;i < n+1;i++){
            for(int j =1;j< N+1;j++){
                if( len[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-len[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][N];
    }
}

public class Solution{
    
    public static void main(String[] args){
        RodCutting rc = new RodCutting();
        int price[] =  {3, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        int N = price.length;
        int[] len = new int[n];
        len = IntStream.rangeClosed(1,n).toArray();
         //Arrays.stream(len).forEach(System.out::print);
         
        int[][] dp = new int[n+1][N+1];
        
        System.out.println("The max profit obtained by cutting the rod is :"
        +rc.findTheMaxProfitForCuttingTheRod(price,len,n,N,dp));
        
        
    }
}

//o/p:- The max profit obtained by cutting the rod is :24
