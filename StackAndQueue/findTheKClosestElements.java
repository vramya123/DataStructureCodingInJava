// Find the K closest elements
//Youtube :- https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=5
//TC = O(nlogk)


import java.io.*;
import java.util.*;

class Pair{
    public int diff;
    public int val;
    public Pair(int diff, int val){
        this.diff = diff;
        this.val = val;
    }
    
}
public class kClosestElements{
    
    public static List<Integer> findTheKClosestElements(int[] arr, int k,int key){
        
        /* logic
        
        2    3     6    9    8     7  k =8
        8-2  8-3  8-6  8-9  8-8  8-7
        6    5     2    1   0     1
        
        1 0 1 are the closest => 7 8 9 Min val needed, so use max heap as we exclude max diff
        */
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.diff-a.diff);
        
        for(int i=-0;i<arr.length;i++){
            maxHeap.add(new Pair(Math.abs(key-arr[i]),arr[i]));
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        while(maxHeap.size() > 0 ){
            res.add(maxHeap.poll().val);
        }
        return res;
    }
    
    public static void main(String[] args){
        int[] a= {2,3,6,9,8,7};
        int key = 7;
        int k = 3;
        List<Integer> res = findTheKClosestElements(a,k,key);
        System.out.println("The "+k+" closest elements to the key "+key+" is:" );
        res.forEach(System.out::print);
    }
}

/*
  
  The 3 closest elements to the key 7 is:
867

*/
