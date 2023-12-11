// Rotate array by D

//Youtube :- https://www.youtube.com/watch?v=wvcQg43_V8U&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=3


import java.io.*;
import java.util.*;


public class RotateArrayByD{
    
    //BruteForce
    public static void rotateGivenArrayByD(int[] a, int d){
    
        List<Integer> tmp = new ArrayList<>();
        int n = a.length;
        
         d = d % n;
        
        //Store rotate items in arrayList
        for(int i=0;i< d;i++){
            tmp.add(a[i]);
        }
        
        //Rotate items from d to begining of array
        //[4 5 6 7 8 9 10]    d = 3
        //  0 1 2 3 4 5 6
        
        for(int i = d;i<n;i++){
            a[i-d] = a[i];
        }
        
        for(int i= n-d; i< n;i++){
          a[i ] = tmp.get(i-(n-d));
        }
        
    }
    
    //optimized Solution
     public static void rotateGivenArrayByDOptimized(int[] a, int d){
         int n = a.length;
        
          d = d % n;
        
         reverse(0,d-1,a);
         reverse(d,n-1,a);
         reverse(0,n-1,a);
    
     }
     
     
     public static void reverse(int l, int h, int[] a){
         int temp;
         
         while(l<=h){
             temp = a[l];
             a[l++]=a[h];
             a[h--]=temp;
         }
     }
    
    
    public static void main(String[] args){
        int[] a = {1,2,3,6,4,5,9};
        
        //rotateGivenArrayByD(a,3);
        
        rotateGivenArrayByDOptimized(a,3);
        
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        
    }
    
}

//o/p :- 6459123
