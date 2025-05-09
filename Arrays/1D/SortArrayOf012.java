/*

Sort An Array of 0s, 1s and 2s

You have been given an array/list 'arr' consisting of 'n' elements.Each element in the array is either 0, 1 or 2.Sort this array/list in increasing order.Do not make a new array/list. Make changes in the given array/list.


Example :
Input: 'arr' = [2, 2, 2, 2, 0, 0, 1, 0]

Output: Final 'arr' = [0, 0, 0, 1, 2, 2, 2, 2]
Explanation: The array is sorted in increasing order.


Youtube:- https://www.youtube.com/watch?v=tp8JIuCXBaU&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=6

*/

import java.io.*;
import java.util.*;


public class SortArrayOf0123{
    
    //Tc : O(2N)   SC : O(1)
    public static void sortTheGivenArrayOf0123UsingBetterApproach(int[] a){
        
        int cnt0 = 0;
        int cnt1 = 0;
         int cnt2 = 0;
        
        for(int i=0;i<a.length;i++){
            
            if(a[i] == 0) cnt0++;
            else if(a[i] ==1 ) cnt1++;
            else cnt2++;
        }
        
        for(int i=0;i<cnt0;i++){
            a[i] = 0;
        }
        
        for(int i = cnt0;i<cnt0 + cnt1;i++){
            a[i] = 1;
        }
        
        for(int i = cnt0 + cnt1;i < a.length;i++){
            a[i] = 2;
        }
        
    }
    
    //Tc:- O(N)  SC:O(1)
    public static void sortTheGivenArrayOf0123UsingDNFAlgo(int[] a){
        
        /*
        
        Using Dutch National Flag Logic for sorting
        
        Intution:-
        
        0   0  0   0  0    1  1   1   1    1    0  1   2  2  1 0  0    2    2    2    2   2
        |             |    |               |    |                 |    |                  |
        0 (sorted)  low-1  low  (sorted)  mid-1 mid (unsorted)   high high+1  (sorted)    n-1
        
        */
        
        int low = 0;
        int mid =0;
        int high = a.length-1;
        
        while(mid <=high ){
        if(a[mid] == 0){
            swap(a,mid,low);
            low++;
            mid++;
        }else if(a[mid] == 1){
            mid++;
        }else{
            swap(a,mid,high);
            high--;
        }
        }
        
    }
    
    public static void swap(int[] a, int l, int h){
        int temp = a[l];
        a[l] = a[h];
        a[h] = temp;
        l++;
        h--;
    }
    
    
    public static void main(String[] args){
        int[] a = {2, 2, 2, 2, 0, 0, 1, 0};
        
        sortTheGivenArrayOf0123UsingBetterApproach(a);
        
        sortTheGivenArrayOf0123UsingDNFAlgo(a);
        
        System.out.println(Arrays.toString(a));
        
        
    }
    
    //o/p:- [0, 0, 0, 1, 2, 2, 2, 2]
}
