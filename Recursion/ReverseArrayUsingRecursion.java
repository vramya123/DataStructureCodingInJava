// Swap an array using recursion 

//Youtube :- https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=5

//TC : O(N)


import java.io.*;
import java.util.*;


public class ReverseArrayUsingRecursion{
    
     public static void reverseTheGivenArrayUsingTwoPointer(int[] a){
         
         reverse(a,0,a.length-1);
     }
     
      public static void reverseTheGivenArrayUsingOnePointer(int[] a){
         
         reverse1(a,0,a.length);
     }
     
     //Two pointer approach 
     public static void reverse(int[] a, int l, int h){
         //base case
         
         if(l >= h){
             return;
         }
         swap(a,l,h);
         reverse(a,l+1,h-1);
     }
     
     
     //One pointer approach
     
     /*
     
     RT
     
     f(a,0,6)
     
     f(a,1,6)
     
     f(a,2,6)
     
     f(a,3,6)
     
     */
     public static void reverse1(int[] a, int i, int n){
         
         //Base case
         if( i >= n/2){
             return;
         }
          swap(a,i,n-i-1);
          reverse1(a, i+1, n); //When i  used i++ , it resulted in stackoverflow 
         
     }
     
     public static void swap(int[] a, int l, int h){
         int tmp = a[l];
         a[l] = a[h];
         a[h] = tmp;
     }
     
     public static void main(String[] args){
         int[] a = {2,3,4,1,5,6};
         reverseTheGivenArrayUsingTwoPointer(a);
         for(int i=0;i<a.length;i++){
             System.out.print(a[i]+" ");
         }
         System.out.println();
         
         reverseTheGivenArrayUsingOnePointer(a);
         for(int i=0;i<a.length;i++){
             System.out.print(a[i]+" ");
         }
     }
}

//o/p:- 6 5 1 4 3 2 
// 2 3 4 1 5 6 
