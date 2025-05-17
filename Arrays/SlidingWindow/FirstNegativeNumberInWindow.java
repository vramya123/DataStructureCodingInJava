/*

First negative in every window of size k


Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Note: If a window does not contain a negative integer, then return 0 for that window.

Examples:

Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
Output: [-8, 0, -6, -6]
Explanation:
Window [-8, 2] First negative integer is -8.
Window [2, 3] No negative integers, output is 0.
Window [3, -6] First negative integer is -6.
Window [-6, 10] First negative integer is -6.


youtube:- https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4

for arr of size 8 and k = 3, the result size is n-k+1 = 8-3+1 = 6

*/

import java.io.*;
import java.util.*;


public class FirstNegativeNumberInWindow{
    
    public static List<Integer> getTheFirstNegativeNumberInGivenWindow(int[] arr, int k, int n){
        
        Queue<Integer> negNumbers = new LinkedList<>();
        int i = 0;
        int j=0;
        List<Integer> res = new ArrayList<>();
        
        while(j < n){
            
            //add neg numbers to a queue
            if(arr[j] < 0){
                negNumbers.add(arr[j]);
            }
            
            if( j-i+1 < k){
                j++;
            }else if( j-i+1 == k){
                //compute the list with first neg numbers for each subset
                res.add(negNumbers.isEmpty() ? 0 : negNumbers.peek());

                // Remove elements that are out of the window
                if (!negNumbers.isEmpty() && arr[i] == negNumbers.peek()) {
                    negNumbers.remove();
                }

                // Slide the window
                i++;
                j++;
                
            }
        }
        return res;
        
    }
    
     public static void main(String[] args){
         
         int[] arr = { -8, 2, 3, -6, 10};
         int n = arr.length;
         int k = 2;
         
         List<Integer> res = getTheFirstNegativeNumberInGivenWindow(arr,k,n);
         
         System.out.println("The list of first neg numbers for the given subset is :"+res);
        
     }
}

//o/p:- The list of first neg numbers for the given subset is :[-8, 0, -6, -6]
