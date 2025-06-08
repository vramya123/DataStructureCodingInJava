/*


youtube:- https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25


Minimum number of deletions and insertions to transform one string into another
Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
Example:
Input : str1 = "geeksforgeeks", str2 = "geeks"
Output : Minimum Deletion = 8
         Minimum Insertion = 0 


s1 = heap      s2 = pea
        LCS = ea

s1.length - LCS size = no : of deletions
s2.length - LCS size = no : of insertions

*/


import java.io.*;
import java.util.*;
import java.util.stream.*;

class MinOfInsertionDeletionToConvertOneStringToAnother{
    
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
    
    public int[] getTheMinOfInsertionDeletionToConvertOneStringToAnother(String s1, String s2){
        
        int minDeletion = 0;
        int minInsertion = 0;
        if(s1.length() > s2.length()){
              minDeletion = s1.length() - LCA(s1,s2,s1.length(),s2.length());
              minInsertion = s2.length() - LCA(s1,s2,s1.length(),s2.length()); 
        }else{
            minDeletion = s2.length() - LCA(s1,s2,s1.length(),s2.length());
            minInsertion = s1.length() - LCA(s1,s2,s1.length(),s2.length()); 
        }
        
        return new int[] {minDeletion,minInsertion};
       
    }
}

public class Solution{
    public static void main(String[] args){
        MinOfInsertionDeletionToConvertOneStringToAnother obj = new MinOfInsertionDeletionToConvertOneStringToAnother();
        String s1 = "geeksforgeeks";
        String s2 = "geeks";
        
        Arrays.stream(MinOfInsertionDeletionToConvertOneStringToAnother.dp).forEach((rows) -> Arrays.fill(rows,-1));
        
        int[] res = obj.getTheMinOfInsertionDeletionToConvertOneStringToAnother(s1,s2);
        System.out.println("The min del and ins to convet s1 to s2 is ");
        Arrays.stream(res).forEach(System.out::println);
    }
}

/*

The min del and ins to convet s1 to s2 is 
8
0

*/
