//Top k frequent elements 
//youtube: https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6
//tc = O(nlogk)

import java.io.*;
import java.util.*;

class Pair{
    public int freq;
    public int val;
    
    public Pair(int freq, int val){
        this.freq = freq;
        this.val = val;
    }
    
}
public class TopKFrequent{
    
    public static List<Integer> getTheTopKFrequentElements(int[] arr, int k){
        
        Map<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.freq-b.freq);
        List<Integer> res = new ArrayList<>();
        
        //get freq hashmap
        for(int i=0;i<arr.length;i++){
            int count = 1;
            if(hm.containsKey(arr[i])){
                count = hm.get(arr[i]);
                count++;
            }
            hm.put(arr[i],count);
        }
        
        //fill the heap
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            minHeap.add(new Pair(entry.getValue(), entry.getKey()));
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        while(minHeap.size() > 0){
            res.add(minHeap.poll().val);
        }
        
        return res;
    }
    
    public static void main(String[] args){
        
        int[] a = {1,2 ,3 ,4,1,1,1,1,1,1 ,5 ,2,4,3,3,4,5,4,5,5};
        List<Integer> res = getTheTopKFrequentElements(a,2);
        System.out.println("The 2 top frequent elements are:");
        res.forEach(System.out::print);
    }
}

/* 
The 2 top frequent elements are:
51
*/
