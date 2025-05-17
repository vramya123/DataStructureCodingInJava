/*

Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

Note: A subarray is a contiguous part of any given array.

Examples:

Input: arr[] = [100, 200, 300, 400] , k = 2
Output: 700
Explanation: arr3  + arr4 = 700, which is maximum.


youtube:- https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3

Logic:-

Identification of sliding window problem:-

1) array
2) substring/subarray
3) window size(fixed) or condition(unfixed)

* Initialize windows size using i and j with 0
* Traverse till array end for j
* calculate sum 
* if length of window is less than given size k, then increment j
* if length of window is equal to given size k, then 
 - check for max sum 
 - minus a[i] from sum
 - increment i
 - increment j
 [all this to move to next window and maintain size]
 
 
 */
 
 import java.util.*;
 import java.io.*;
 
 
 public class MaxSumSubArrayOfSizeK{
     
     public static int findtheMaxSumSubArrayOfSizeK(int[] arr, int k, int n){
         
         int max = Integer.MIN_VALUE;
         int sum = 0;
         int i =0;
         int j=0;
         
         while( j < n){
             
             //calculate sum
             
             sum += arr[j];
             
             //checl if window size is reached
             
             if(j-i+1 < k){
                 j++;
             }else if( j-i+1 == k){
                 //find if sum is the max
                 max = Math.max(sum, max);
                 
                 //maintain window size and move forward
                 
                 sum-= arr[i];
                 i++;
                 j++;
             }
         }
         
         return max;
     }
     
     public static void main(String[] args){
         
         int[] arr = { 100, 200, 300, 400};
         int n = arr.length;
         int k = 2;
         
         System.out.println("The max sum subarray of size "+k+" is:"+findtheMaxSumSubArrayOfSizeK(arr,k,n));
     }
 }
 
 //o/p:- The max sum subarray of size 2 is:700
