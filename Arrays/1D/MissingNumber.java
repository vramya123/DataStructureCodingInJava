//Missing Number 
//Given an array of non duplicates numbers ranging from 1 to N with one missing number, find it with optimal solution
// A = [ 1,2,4,5]  N = 5
//O/p : 3

//Youtube : https://www.youtube.com/watch?v=bYWLJb3vCWY&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=3

import java.io.*;
import java.util.*;


public class MissingNumber{
    
    //BruteForce
    //TC - O(N) * O(N) = O(N^2)
    public static int findMissingNumber(int[] arr, int n){
        
        int missingNum;
        int flag;
        
        for(int j=1;j<=n;j++){
         flag = 0;
         for(int i=0; i< n-1;i++){
            if(arr[i] == j){
                flag = 1;
                break;
            }
         }
         if(flag == 0){
             return j;
         }
        } 
        return -1;
    }
    
    
    //Hash 
    // TC = O(N) + O(N) ~ O(N)
    public static int findMissingNumberUsingHash(int[] arr, int n){
      int[] hash = new int[n+1];
      
      for(int i =0;i<n-1;i++){
          hash[arr[i]] = 1;
      }
      
      for(int i= 1 ;i <n+1;i++){
          if(hash[i] != 1){
              return i;
          }
      }
      return -1;
    
    }
    
    //summation optimal solution
    //TC = O(N)
     public static int findMissingNumberUsingSummation(int[] arr, int n){
      
      int summation = (n * (n+1))/2;
      int sum = 0;
      
      for(int i =0;i< n-1;i++){
          sum += arr[i];
      }
      
      return summation - sum;
         
     }   
     
     //xor optimal solution
     //TC = O(N) 
     public static int findMissingNumberUsingXOR(int[] arr, int n){
      
      int xor1 = 0;
      int xor2 = 0;
      
      for(int i=0;i< n-1;i++){
          xor1 += arr[i];
          xor2 +=  i+1;
      }
      xor2 += n;
      return xor1 ^ xor2;
      
     }
     
     
     public static void main(String[] args){
         int[] arr = { 1, 2, 4, 5};
         int n = 5;
         
         
         System.out.println(findMissingNumber(arr,n));
         
         
         System.out.println(findMissingNumberUsingHash(arr,n));
         
         
         System.out.println(findMissingNumberUsingSummation(arr,n));
         
         
         System.out.println(findMissingNumberUsingXOR(arr,n));
         
     }
    
}

//O/p : 3
