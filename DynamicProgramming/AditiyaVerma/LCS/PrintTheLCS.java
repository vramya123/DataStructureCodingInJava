/*

 Print the Longest common subsequence(LCS)

subsequence :- The elements can have gap between but needs to be in order
substring: The elements  needs to be contiguoug and no gaps

youtube:- https://www.youtube.com/watch?v=hR3s9rGlMTU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23


   str1 = abcdefg    str2 = abfgj
   
   if(str1[n-1] == str[m-1])
       1+  lcs(str1, str2, n-1, m-1) //add 1 beacuse we have one common letter
   else
      choice diagram
      we can consider str1 full and check with str2 leaving last one or 
      we can take str1 leaving last one and compare with str2 full
      
      Math.max(lcs(str1,str2,n-1,m) , lcs(str1,str2, n, m-1))
      
      We use max as we need longest common substring
  
  ** We we have recusrion, we need to think of the followings***
  
  Recusrion always has choices. 
  1) Base csae
  2) Make input smaller each time
  3) choice diagram
  
  Recusrion 
  => if we have more than one branching in each recusrion call , it leads to Dp
  => dp ie, memoization or bottom up where sun problem results are stored and used in recusrion , it then leads to top down
  => top down where we just use the matrix to avoid stack overflow which results due to many recusrion calls
  
 */
       
       
 import java.io.*;
 import java.util.*;
 import java.util.stream.*;
 
 class PrintTheLCS{
     public static int[][] dp = new int[1001][1001];
     
     //top-down
      public String getTheLongestSubSequenceForGivenStringsUsingTopDown(String str1, String str2, int m, int n){
         
        //base case => initilaization
        for(int i = 0;i < m+1;i++)
          dp[0][i] = 0;
         
        for(int j =0;j< n+1;j++)
         dp[0][j]= 0;
         
         //choice diagram
         
        for(int i =01;i< m+1;i++){
            for(int j =1;j< n+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                     dp[i][j] = 1+ dp[i-1][j-1];
                 }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        
        //We need to traverse the dp matrix to print the longest subsequence
        int i = m, j = n;
        StringBuilder str = new StringBuilder();
        
        while(i > 0 || j > 0){
            
            //compare the string value at end of table
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                str.insert(0,str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1])
                   i--;
                else
                   j--;
            }
        }
         return str.toString();
     }
 }
 
 public class Solution{
     public static void main(String[] args){
         PrintTheLCS lcs = new PrintTheLCS();
         
         String s1 = "abcdefg";
         String s2 = "abgfh";
         
         int m = s1.length();
         int n = s2.length();
         
         Arrays.stream(PrintTheLCS.dp).forEach((rows) -> Arrays.fill(rows,-1));
         
         System.out.println("The longest common subsequence  is "+lcs.getTheLongestSubSequenceForGivenStringsUsingTopDown(s1,s2,m,n));
     }
 }
 
 //o/p:- The longest common subsequence  is abg
