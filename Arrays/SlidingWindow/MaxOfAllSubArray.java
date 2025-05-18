/*

Maximum of all subarrays of size k


Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

Example:

Input 1:
    A = [1, 3, -1, -3, 5, 3, 6, 7]
    B = 3
Output 1:
    C = [3, 3, 5, 5, 6, 7] . 
    

youtube:- https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6

*/


import java.io.*;
import java.util.*;

public class MaxOfAllSubArray{
    
    public static List<Integer> getTheMaximumOfAllSubArrayOfSizeK(int[] arr, int k, int n){
        
        Deque<Integer> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        
        int i=0,j=0;
        
        while(j < n){
            
            //compute the maximum and put in a dequeue
            //In an array, all elements before that which are less are not needed as we want max for a substring
            
            while(q.size() > 0  && q.peekLast() < arr[j]){
                 q.removeLast();
            }
            
            q.addLast(arr[j]);
            
            
            if(j-i+1 < k){
                j++;
            }else if ( j-i+1 == k){
                
                //put answer ie, max in the list
                res.add(q.peekFirst());
                
                //slide window
                if(arr[i] == q.peekFirst()){
                    q.removeFirst();
                }
                
                i++;
                j++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args){
         
         int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7};
         int n = arr.length;
         int k = 3;
         
         System.out.println("The max sum subarray of size "+k+" is:"+getTheMaximumOfAllSubArrayOfSizeK(arr,k,n));
     }
}

//o/p:- The max sum subarray of size 3 is:[3, 3, 5, 5, 6, 7]
