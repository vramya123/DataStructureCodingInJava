//Move all 0's in an array to the end
//i/p : {1,2,0,3,4,0}
//o/p:- { 1,2,3,4,0,0}

//Youtube :- https://www.youtube.com/watch?v=wvcQg43_V8U&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=3


import java.io.*;
import java.util.*;


public class MoveZerosToEnd{
    
    //BruteForce
    public static void moveZerosToEndForGivenArray(int[] a){
    
        List<Integer> tmp = new ArrayList<>();
        int n = a.length;
        
        //Store all non-zero in a list
        for(int i=0;i< n;i++){
            if(a[i] != 0){
             tmp.add(a[i]);
            }
        }
       
       //Put nonzero elements to array
        for(int i = 0;i<tmp.size();i++){
            a[i] = tmp.get(i);
        }
        
        //Fill rest of array with zero
        for(int i= tmp.size(); i < n;i++){
          a[i] = 0;
        }
        
    }
    
    //optimized Solution
     public static void moveZerosToEndForGivenArrayOptimized(int[] a){
        //Two pointer approach
        int n = a.length;
        
        int j = -1;
        
        //Get first occurance of 0
        for(int i=0;i<n;i++){
            if(a[i] == 0){
                j=i;
                break;
            }
        }
        
        //if j = -1, then no 0 in array
        if(j == -1) return;
        
        //Swap  zero with non-zero
        for(int i=j+1;i<n;i++){
            if(a[i] != 0){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                j++;
            }
        }
    
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
        int[] a = {1,2,0,3,6,0,4,5,9};
        
        //moveZerosToEndForGivenArray(a);
        
        moveZerosToEndForGivenArrayOptimized(a);
        
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        
    }
    
}

//o/p :- 123645900
