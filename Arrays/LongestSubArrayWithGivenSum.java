/*

You are given an array 'a' of size 'n' and an integer 'k'.Find the length of the longest subarray of 'a' whose sum is equal to 'k'.

Example :
Input: ‘n’ = 7 ‘k’ = 3
‘a’ = [1, 2, 3, 1, 1, 1, 1]

Output: 3

Explanation: Subarrays whose sum = ‘3’ are:

[1, 2], [3], [1, 1, 1] and [1, 1, 1]

Here, the length of the longest subarray is 3, which is our final answer.

Subarray:- Contiguous array
Subsequence :- Need not be contiguous

*/


import java.io.*;
import java.util.*;

public class LongestSubArrayWithGivenSum{
    
    /*
    Brute force
    TC:- O(n2)  SC :- O(1)
    */
    public static int longestSubArrayWithSumForAGivenArray(int[] a, int k){
        
        int n = a.length;
        int maxLen = 0;
        
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+= a[j];
                if(sum == k){
                    maxLen = Math.max(maxLen,j-i+1);
                }
            }
        }
        
        return maxLen;
    }
    
    /*
    Better Solution
    TC : O(N LogN) if ordered hashMap with coliision or O(N * 1) for unordered hashMap without collision and O(N * N) with collision 
    SC : O (N)
    
    This is optimal solution if array contains negative and positive elements
    
    */
    public static int longestSubArrayWithSumForAGivenArrayBetterSolution(int[] a, int k){
        
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        
        for(int i=0;i<n;i++){
            sum+= a[i];
            
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }
            
            int rem = sum - k;
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            
        }
        
        return maxLen;
    }
    
    
    /*
    Optimal Solution
    
    This is optimal solution if array contains positive and zero elements
    
    TC : O(2N) 
    SC : O(1)
    
    
    Two pointer appproach with shrinking if sum is greater than k
    
    */
    
    
    public static int longestSubArrayWithSumForAGivenArrayOptimalSolution(int[] a , int k){
        
        int left = 0;
        int right = 0;
        
        int n = a.length;
        int maxLen = 0;
        int sum = a[0];
        
        while(right < n){
            
            while( left <= right && sum > k){
                sum -= a[left];
                left++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
            
            if(right < n){
                sum += a[right];
            }
            
        }
        return maxLen;
    }
    
    
    public static void main(String[] args){
        
        int[] a = {1, 2, 3, 1, 1, 1, 1};
        
        int k = 3;
        
        System.out.println("Brute force :- The longest sub array length with given sum is : "+longestSubArrayWithSumForAGivenArray(a,k));
        //Brute force :- The longest sub array length with given sum is : 3
        
        System.out.println("Better force :- The longest sub array length with given sum is : "+longestSubArrayWithSumForAGivenArrayBetterSolution(a,k));
        //Better force :- The longest sub array length with given sum is : 3
        
         System.out.println("Optimal force :- The longest sub array length with given sum is : "+longestSubArrayWithSumForAGivenArrayOptimalSolution(a,k));
        //Optimal force :- The longest sub array length with given sum is : 3

    }
    
}
