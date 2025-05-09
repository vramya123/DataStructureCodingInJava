//Find the second largest and largest in the given array. Also find the second smallest and the smallest in the array

//Youtube : https://www.youtube.com/watch?v=37E9ckMDdTk&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB

//Bruteforce:- sort array and pick last index for largest, first index for smallest. For second largest, traverse from last but 1 till begining and see if its not equal to largest . Similarly for smallest


import java.io.*;
import java.util.*;


public class SecondLargestSmallestInArray{
    
    public static int[] findSecondLargestAndLargestInArray(int[] a){
        
        
        int largest = a[0];
        int secondLargest = Integer.MIN_VALUE;
        
        for(int i=1;i<a.length;i++){
            if(a[i] > largest){
                secondLargest = largest;
                largest = a[i];
            }else if(a[i] < largest && a[i] > secondLargest ){ // If a[i] equal to largest do not do anything 
                secondLargest = a[i];
            }
        }
        
         int[] firstSecondLargest = {largest, secondLargest};
        
        return  firstSecondLargest;
        
    }
    
     public static int[] findSecondSmallestAndSmallestInArray(int[] a){
        
        
        int smallest = a[0];
        int secondSmallest = Integer.MAX_VALUE;
        
        for(int i=1;i<a.length;i++){
            if(a[i] <  smallest){
                secondSmallest = smallest;
                smallest = a[i];
            }else if(a[i] > smallest && a[i] < secondSmallest ){ // If a[i] equal to smallest do not do anything
                secondSmallest = a[i];
            }
        }
        
        int[] firstSecondSmallest = {smallest, secondSmallest};
        
        return firstSecondSmallest;
        
    }
    
    
    public static void main(String[] args){
        
        int[] a = {1,4,2,7,-3,7};
        
        int[] b = { -5 , 6, 1, 2 ,3,5,6};
        
        int[] c = findSecondLargestAndLargestInArray(a);
        
        System.out.println(c[0]+","+c[1]);
        
         c = findSecondSmallestAndSmallestInArray(a);
         
       System.out.println(c[0]+","+c[1]);
        
        
    }
    
}

//o/p:- 
//7,4
//-3,1
