/*

You are given a sorted array 'arr' of distinct values and a target value 'm'.You need to search for the index of the target value in the array.


Note:
If the value is present in the array, return its index.
If the value is absent, determine the index where it would be inserted in the array while maintaining the sorted order. 


Example:
               0 1  2   3
Input:  arr = [1, 2, 4, 7],  m = 6 

Output: 3

Explanation: If the given array 'arr' is: [1, 2, 4, 7] and m = 6. We insert m = 6 in the array and get 'arr' as: [1, 2, 4, 6, 7]. The position of 6 is 3 (according to 0-based indexing)


Youtube :- https://www.youtube.com/watch?v=6zhGS79oQ4k&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=3


*/


import java.io.*;
import java.util.*;


public class FindIndexOfTarget{
    
    
    //Finding lower bound ie, smallest index >= x ie, a[index] >= x
    public static int findIndexOfTargetInGivenArray(int[] a, int target){
        
        int low = 0;
        int high = a.length-1;
        int ans = a.length;
        
        while(low <= high){
            
            int mid = low + (high-low)/2;
            
            if(a[mid] >= target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        return ans;
    }
    
    
    public static void main(String[] args){
        
        int[] a = { 2, 3, 5, 7, 9, 10,10};
        int target = 7;
        
        System.out.println("The index for target is :"+ findIndexOfTargetInGivenArray(a,target));
        //The index for target is :7 [for target = 11]
        
         //The index for target is :3 [for target = 7]
    }
}
