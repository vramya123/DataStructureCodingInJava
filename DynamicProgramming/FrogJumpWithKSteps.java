/*

There are N stones, numbered 1,2,…,N. For each i (1≤i≤N), the height of Stone i is h [i]

There is a frog who is initially on Stone 1. He will repeat the following action some number of times to reach Stone N:

If the frog is currently on Stone i, jump to one of the following: Stone i+1,i+2,…,i+K. Here, a cost of |hi−hj∣ is incurred, where j is the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone N.

Youtube:- https://www.youtube.com/watch?v=Kmh3rhyEtB8&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5


*/

import java.io.*;
import java.util.*;

public class FrogJumpWithKSteps{
    
    public static int frogWithKStepsUsingMemoization(int i, int[] a, int[] dp,int k){
        //base case
        
        if( i == 0)
          return 0;
        
        if(dp[i] != -1) 
           return dp[i];
        
        int minJump = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(i-j >= 0){
            int jump = frogWithKStepsUsingMemoization(i-j, a, dp,k) + Math.abs(a[i]- a[i-j]);
            minJump = Math.min(minJump,jump);
            }
        }
        
        return dp[i]= minJump;
        
        //TC=O(N*K)
        //SC=O(N) + O(N)
    }
    
    
     public static int frogWithKStepsUsingTabulation(int n, int[] a, int[] dp,int k){
         
        dp[0] = 0;
        for(int i=1;i<n;i++){
          int minJump = Integer.MAX_VALUE;
          for(int j=1;j<=k;j++){
            if(i-j >= 0){
            int jump = dp[i-j] + Math.abs(a[i]- a[i-j]);
            minJump = Math.min(minJump,jump);
           }
         }
         dp[i] = minJump;
        }
        
        return dp[n-1];
        //TC=O(N*K)
        //SC=O(N)
     }
    
    
    public static void main(String[] args){
        
        int n = 5;
        int k =3;
        int[] a = {10,30,40,50,20};
        int[] dp = new int[a.length];
        Arrays.fill(dp,-1);
        System.out.println("The frog jumps is : "+frogWithKStepsUsingMemoization(n-1,a,dp,k));
        //The frog jumps is : 30
        
         System.out.println("The frog jumps is : "+frogWithKStepsUsingTabulation(n,a,dp,k));
        //The frog jumps is : 30
    }
    
}
