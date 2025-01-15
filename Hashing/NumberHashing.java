/*


Hashing 

Time complexity
================

Ordered Map : Best case, worst case and average case TC is O(log n)

Unordered Map : Best case, average case TC is O(1) and worst case is O(n)


Implementation
===============





*/


import java.io.*;
import java.util.*;


public class NumberHashing{
    
    //array containing known numbers
    public static int checkNumberOccurranceInGivenArray(int[] arr, int key){
        
        //hash array
        int[] hash = new int[13]; //size is 13 if we know that array contains number only upto 12
        Arrays.fill(hash,0);
        
        //creation of hash array
        for(int i = 0;i<arr.length;i++){
            hash[arr[i]]++;
        }
        
        return (hash[key] !=0 ? hash[key] : 0);
    }
    
     //array containing unknown numbers
    public static int checkNumberOccurranceInGivenArraySpl(int[] arr, int key){
        
        //hash array
        Map<Integer, Integer> hash = new HashMap<>();
        
        //creation of hash array
        for(int i=0;i<arr.length;i++){
            int val = hash.getOrDefault(arr[i],0);
            hash.put(arr[i],val+1);
        }
        
        // Print the HashMap using Streams
        hash.entrySet().stream().
        forEach(entry -> System.out.println("key is :"+ entry.getKey()+ "and val is :"+entry.getValue()));
        

        return hash.getOrDefault(key,0);
    }
    
    
    public static void main(String[] args){
        
        int[] n = {2,3,1,7,6,7,8,9};
        int key = 7;
        
        System.out.println("The occurrence of number "+ key +" is :" +checkNumberOccurranceInGivenArray(n,key));
        
        int[] m = {2,3,1,7,6,7,899,9};
        key = 899;
        System.out.println("The occurrence of number "+ key +" is :" +checkNumberOccurranceInGivenArraySpl(m,key));
    }
    
}

/* o/p:-

The occurrence of number 7 is :2
key is :1and val is :1
key is :2and val is :1
key is :3and val is :1
key is :899and val is :1
key is :6and val is :1
key is :7and val is :2
key is :9and val is :1
The occurrence of number 899 is :1
*/
