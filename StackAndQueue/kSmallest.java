//K smallest in a given array
// youtube : https://www.youtube.com/watch?v=4BfL2Hjvh8g&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=2
// TC = O(nlogk)

import java.io.*;
import java.util.*;

public class kSmallest{
    
    
    public static int findTheKSmallest(int[] arr, int k){
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0;i<arr.length;i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
    
    public static int findTheKLargest(int[] a, int k){
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i =0;i<a.length;i++){
            minHeap.add(a[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    
    public static List<Integer> findKSmallest(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        while(maxHeap.size() > 0){
            res.add(maxHeap.poll());
        }
        return res;
    }
    
    public static void main(String[] args){
        int[] a = { 7,6,1,2,0};
        int k = 3;
        System.out.println("The "+k +" smallest element is :"+findTheKSmallest(a,k));
        System.out.println("The "+k +" largest element is :"+findTheKLargest(a,2));
        List<Integer> res = findKSmallest(a,k);
         System.out.println("The "+k +" smallest elements are :");
         res.forEach(System.out::print);
    }
}

/*


The 3 smallest element is :2
The 3 largest element is :6
The 3 smallest elements are :
210
*/
