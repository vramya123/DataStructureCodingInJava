/*

Longest common substring

subsequence :- The elements can have gap between but needs to be in order
substring: The elements  needs to be contiguoug and no gaps

youtube:- https://www.youtube.com/watch?v=hR3s9rGlMTU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=21


  When comparing , if two letters are same, only then we increment count. 
  If not same, we reset the counter and start again.
  
 */
       
       
 import java.io.*;
 import java.util.*;
 import java.util.stream.*;
 
 class LongestCommonSubstring{
     public static int[][] dp = new int[1001][1001];
     
     //top-down
      public int getTheLongestSubstringForGivenStringsUsingTopDown(String str1, String str2, int m, int n){
         
        //base case => initilaization
        for(int i = 0;i < m+1;i++)
          dp[0][i] = 0;
         
        for(int j =0;j< n+1;j++)
         dp[0][j]= 0;
         
         //choice diagram
         
        for(int i =1;i< m+1;i++){
            for(int j =1;j< n+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                     dp[i][j] = 1 + dp[i-1][j-1];
                 }else{
                     dp[i][j] = 0;
                }
            }
        }
        
        //Find the max in the matrix as the substring can exist anywhere and return that
        /*int max = Integer.MIN_VALUE;
        for(int i =0;i <m+1;i++){
            for(int j =0;j<n+1;j++){
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
         return max;*/
        return Arrays.stream(dp).flatMapToInt(Arrays::stream).max().orElse(Integer.MIN_VALUE);
        
        
     }
 }
 
 public class Solution{
     public static void main(String[] args){
         LongestCommonSubstring lcs = new LongestCommonSubstring();
         
         String s1 = "abcdefg";
         String s2 = "abgfh";
         
         int m = s1.length();
         int n = s2.length();
         
         Arrays.stream(LongestCommonSubstring.dp).forEach((rows) -> Arrays.fill(rows,-1));
         
         System.out.println("The longest common substring length is "+lcs.getTheLongestSubstringForGivenStringsUsingTopDown(s1,s2,m,n));
     }
 }
 
 //o/p:- The longest common substring length is 2
