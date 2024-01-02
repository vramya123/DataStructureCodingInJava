// Swap an array using recursion 

//Youtube :- https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=5

//TC : O(N)


import java.io.*;
import java.util.*;


public class ReverseArrayUsingRecursion{
    
     public static void reverseTheGivenArray(int[] a){
         
         reverse(a,0,a.length-1);
     }
     
     public static void reverse(int[] a, int l, int h){
         //base case
         
         if(l >= h){
             return;
         }
         swap(a,l,h);
         reverse(a,l+1,h-1);
     }
     
     public static void swap(int[] a, int l, int h){
         int tmp = a[l];
         a[l] = a[h];
         a[h] = tmp;
     }
     
     public static void main(String[] args){
         int[] a = {2,3,4,1,5,6};
         reverseTheGivenArray(a);
         for(int i=0;i<a.length;i++){
             System.out.print(a[i]+" ");
         }
     }
}

//o/p:- 6 5 1 4 3 2 
