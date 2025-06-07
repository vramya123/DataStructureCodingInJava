/*

Partition a set into two subsets such that the difference of subset sums is minimum

Given an array arr[] of size n, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum. 
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) - sum(Subset2)) should be minimum.

Example: 

Input: arr = [1, 6, 11, 5]
Output: 1
Explanation: S1 = [1, 5, 6], sum = 12,  S2 = [11], sum = 11,  Absolute Difference (12 - 11) = 1

Input: arr = [1, 5, 11, 5]
Output: 0
Explanation: S1 = [1, 5, 5], sum = 11, S2 = [11], sum = 11, Absolute Difference (11 - 11) = 0 


youtube:- https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=18

*/


import java.io.*;
import java.util.*;

public class MinDiffPartition{
    
    
    public static int getTheMinDiffPartition(int[] arr){
        
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        
        
        //Let's compute the range first
        int range = 0;
       
        
        for(int i = 0;i < arr.length;i++){
             range += arr[i];
        }
        
        /*We need to minimize  
        s2-s1 = minmize (Assume s2 will be bigger always by restricting s1 to range/2)
        (range -s1) - s1 = minimize 
        range - 2s1 = minimize
        
        ---------------------------------------
        0              range/2               range
        
        */
        
       
        boolean[][] dp = new boolean[n+1][range+1];
        for(boolean[] row : dp){
            Arrays.fill(row,false);
        }
        
        subSetSumProblem(arr, n, range, dp);
        
        //Here we get the range row from the last row of dp. 
        //Now we will filter the values within range/2 and returm them in the new array
        boolean[] v = new boolean[dp[0].length];
        for(int j = 0;j < dp[0].length;j++){
            v[j] = dp[n][j];
        }
        
        //true false false false false true false false false false false true false false false false true true false false false true true 0

        
        for(int i =0 ;i <= v.length/2; i++){  //please note = here, else we will get wrong ans
            if(v[i]){
                min = Math.min(min,(range-2*i));
            }
        }
        
        return min;
    }
    
    
    public static boolean[][] subSetSumProblem(int[] arr, int n, int range, boolean[][] dp){
        //initialization
        for (int j = 0; j < range+1; j++) { // we need separate initiliazation else it does not work
             dp[0][j] = false; 
        }
     
        for (int i = 0; i < n+1; i++) {
             dp[i][0] = true; // There's always one way to get sum 0 (by taking an empty subset)
        } 
        
        
        
        
        //choice diagram
       
        for(int i =1;i<n+1;i++){
            for(int j =1;j<range+1;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else if (arr[i-1] > range){
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp;
        
    }
    
    
    public static void main(String[] args){
        
        int n = 4;
        int[] arr ={1, 5, 11, 5};
       
        
        System.out.println("The min diff partition is:"+getTheMinDiffPartition(arr));
        
    }

}

//The min diff partition is:0
