//Find the number that appear once and other number twice
//Youtube :https://www.youtube.com/watch?v=bYWLJb3vCWY&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=3



import java.io.*;
import java.util.*;


public class NumberThatAppearsOnce{
    
    //better solution using map
    public static int findTheNumberThatAppearsOnceUsingMap(int[] a){
        
        
        int ans = -1;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        //put values in map
        //Tc : O(NlogM) where M is size of map
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                 int count = map.get(a[i]);
                 count++;
                 map.put(a[i],count);
            }else{
                 map.put(a[i],1);
            }
        }
        
        //Traverse the map
        //TC : O(N/2)+1  Each element appears more than once so its number of elements(N) by 2 plus that one element that appears once
       
       for(Map.Entry<Integer,Integer> entry : map.entrySet()){
           if(entry.getValue() == 1){
               ans = entry.getKey();
           }
       }
       
       return ans;
    }
    
     //optimal solution using xor
     public static int findTheNumberThatAppearsOnceUsingXor(int[] a){
         
         int xor = 0;
         
         for(int i =0;i< a.length;i++){
             xor ^= a[i];
         }
         
         return xor;
     }
     
     
     public static void main(String[] args){
         
         int[] a = {-9,2,3,4,2,3,4,-3,-9};
         
         int val = findTheNumberThatAppearsOnceUsingXor(a);
         System.out.println("The non repeating number using xor approach is :"+ val);
         
         val = findTheNumberThatAppearsOnceUsingMap(a);
         System.out.println("The non repeating number using map approach is :"+ val);
         
         
     }
    
}

//o/p
//The non repeating number using xor approach is :-3
//The non repeating number using map approach is :-3
