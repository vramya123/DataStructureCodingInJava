/*
Count the number of subset with a given difference

youtube:- https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11

*/


import java.io.*;
import java.util.*;


class CountNoOfSubsetWithGivenDiff{
    
    
    /*
    
    arr =>  subset1(s1)  - subset2(s2) = diff
    
    eq1  =>  s1 - s2 = diff
    eq2 =>   s1 + s2 = summation
    
    eq1 + eq 2 => 2s1 = diff+ summation 
               =>  s1 = (diff + summation)/2
               
    
    Now we have reduce the problem to count the number of subset whose sum is equal to s1
    
    
    */
    
    
    public int countTheNoOfSubsetWithTheGivenDiff(int[] arr, int diff){
        
        //Find the summation
        int sum = Arrays.stream(arr).reduce(0,(total,item) -> total+item);
        int s1 = (diff + sum)/2;
        
        //Invoke the count the number of subset with sum s
        
        int[][] dp = new int[arr.length+1][s1+1];
        Arrays.stream(dp).forEach((row) -> {
                    Arrays.fill(row,0);
        });
        
        return subSetSumCountProblem(arr,arr.length,s1,dp);
        
    }
    
    
    public int subSetSumCountProblem(int[] arr, int n, int sum, int[][] dp){
        
        //initialization
        for(int j= 0;j < sum+1;j++){
            dp[0][j] = 0;
        }
        
        for(int i = 0;i < n+1;i++){
            dp[i][0] = 1;
        }
        
        for(int i =1;i< n+1;i++){
            for(int j = 1;j<sum+1;j++){
                if(arr[i-1] <=  j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
    
}

public class Solution{
    
    public static void main(String[] args){
        
        int[] arr = {1,1,2,3};
        int diff = 1;
        CountNoOfSubsetWithGivenDiff obj = new CountNoOfSubsetWithGivenDiff();
        
        System.out.println("The count is "+obj.countTheNoOfSubsetWithTheGivenDiff(arr,diff));
    }
}

//o/p:- The count is 3
