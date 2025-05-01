/*

Sort k sorted array 

The correct element in the index "i" can be found "i+k" or "i-k" range only

youtube:- https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4

TC = O(nlogk)

*/

import java.io.*;
import java.util.*;

public class KSortedArray{
    
    public static List<Integer> sortTheKSortedArray(int[] arr, int k){
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0;i < arr.length; i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
                res.add(minHeap.poll());
            }
        }
        
        while(minHeap.size() > 0 ){
            res.add(minHeap.poll());
        }
        
        return res;
    }
    
     public static void main(String[] args){
        int[] a = { 6,5,3,2,8,10,9};
        int k = 3;
        List<Integer> res = sortTheKSortedArray(a,k);
         System.out.println("The "+k +" sorted array elements are :");
         res.forEach(System.out::print);
    }
}
/*

The 3 sorted array elements are :
23568910

*/
