//Merge two sorted array 

//Youtube :- https://www.youtube.com/watch?v=n7uwj04E0I4&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=24


import java.io.*;
import java.util.*;

public class MergeTwoSortedArray{
    
public static void mergeTwoGivenSortedArrayWithAdditionalSpace(int[] a, int[] b){
    
    int n = a.length;
    int m = b.length;
    int index = 0;
    int i=0;
    int j=0;
    int[] merge = new int[n+m];
    
    while(i < n && j<m){
        if(a[i] <= b[j]){
            merge[index++] = a[i++];
        }else{
            merge[index++] = b[j++];
        }
    }
    
    while(i < n){
        merge[index++] = a[i++];
    }
    
    while( j<m){
        merge[index++] = b[j++];
    }
    
    for(int k=0;k<merge.length;k++){
        if(k<n)
            a[k] = merge[k];
        else
           b[k-n] = merge[k];
    }
    
    
    //Tc : O(n+m) + O(n+m)
    //Sc : O(n+m)
    
}

public static void swap(int[] a, int[] b, int i, int j){
    int tmp = a[i];
    a[i] = b[j];
    b[j] = tmp;
}

public static void mergeTwoGivenSortedArrayWithOutAdditionalSpaceUsingGapApproach(int[] a, int[] b){
    int n = a.length;
    int m = b.length;
    int len = n+m;
    int gap = (len/2) + (len%2); // modulus helps to take ceiling function 
    
    while(gap > 0){
        int left = 0;
        int right = len+gap;
        while(right < len){
            //one pointer in a[] array and one pointer in b[] array
            if(left < n && right >= n){
               if(a[left] > b[right-n]){
                   swap(a,b,left,right-n);
               }
            //Both pointers are in the a[] array
            }else if( left < n && right < n){
                if(a[left] > b[right]){
                    swap(a,b,left,right);
                }
            
            //Both pointers are in the b[] array ie, left > n && right > n        
            }else{
                if(a[left-n] > b[right-n]){
                    swap(a,b,left-n,right-n);
                }
            }
            
            left++;
            right++;
            
        }
        gap = (gap/2) + (gap %2);
        if(gap ==1) break;
    }
    
    //TC : O(log(n+m)) +O(n+m)
    //SC : O(1)
    
}


public static void main(String[] args){
    
    int[] a ={1,2,3,4};
    int[] b = {4,5,6,6};
    
    mergeTwoGivenSortedArrayWithAdditionalSpace(a,b);
    
    System.out.println("The merged sorted array using additional space is:");
   for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
    }
     for(int i=0;i<b.length;i++){
        System.out.print(b[i]+" ");
    }
    
    mergeTwoGivenSortedArrayWithOutAdditionalSpaceUsingGapApproach(a,b);
      System.out.println("\nThe merged sorted array using gap approach is:");
    for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
    }
     for(int i=0;i<b.length;i++){
        System.out.print(b[i]+" ");
    }
 }
}
