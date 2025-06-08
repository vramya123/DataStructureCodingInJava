/*

youtube:- https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24

Shortest Common SuperSequence
Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
Examples:

Input:   str1 = "geek",  str2 = "eke"
Output: "geeke"


Supersequence means a sequence from which we get both strings. 
The sequence need not be contiguous but needs to be in order.


Shortest supersequence can be obtained by writing the longest common subsequence only once with the rest of the letters ie,
str1 length is m 
str2 length is n
shortest supersequence length is m+n-LCA(str1,str2)

*/

import java.io.*;
import java.util.*;
import java.util.stream.*;

class ShortestSuperSequence{
    
    public static int[][] dp = new int[1001][1001];
    
    public int LCA(String s1, String s2, int m, int n){
       
       //initialization
       for(int i=0;i<m+1;i++)
          dp[i][0] =0;
    
       for(int j =0;j< n+1;j++)
          dp[0][j] =0;
        
       for(int i =1;i < m+1;i++){
           for(int j =1;j<n+1;j++){
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                   dp[i][j] = 1 + dp[i-1][j-1];
               }else{
                   dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
               }
           }
       }
       
       return dp[m][n];
    }
    
    public int getShortestSuperSequence(String s1, String s2){
        
        int m = s1.length();
        int n = s2.length();
        
        return m+n-LCA(s1,s2,m,n);
    }
    
}

public class Solution{
    public static void main(String[] args){
    String s1 = "geek";
    String s2 = "eke";
    ShortestSuperSequence ss = new ShortestSuperSequence();
    
    Arrays.stream(ShortestSuperSequence.dp).forEach((row) -> Arrays.fill(row,-1));
    
    System.out.println("The Shortest super sequence is :"+ss.getShortestSuperSequence(s1,s2));
    }
}

//o/p:- The Shortest super sequence is :5
