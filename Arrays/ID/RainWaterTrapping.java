//Rain water trapping

//youtube: https://www.youtube.com/watch?v=FbGG2qpNp4U&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=9

//TC = O(n)


import java.io.*;
import java.util.*;

public class RainWaterTrapping{
    
    public static int getTotalRainWaterThatCanBeTrapped(int[] a){
        
        int[] maxLeft = new int[a.length];
        int[] maxRight = new int[a.length];
        int[] water = new int[a.length];
        
        //max towards left for each index
        maxLeft[0] = a[0];
        for(int i= 1;i<a.length;i++){
            maxLeft[i] = Math.max(maxLeft[i-1],a[i]);
        }
        
         //max towards right for each index
         maxRight[a.length-1] = a[a.length-1];
         for(int i=a.length-2;i>=0;i--){
             maxRight[i] = Math.max(maxRight[i+1],a[i]);
         }
         
         //Computer water for each index
         for(int i=0;i<a.length;i++){
             water[i] = Math.min(maxLeft[i],maxRight[i]) - a[i];
         }
         
         //Sum the water contents
         int sum =0;
         for(int i=0;i<a.length;i++){
             sum += water[i];
         }
         
         return sum;
    }
    
    public static void main(String[] args){
        int[] a = {3, 0, 0, 2, 0, 4};
        
        System.out.println("The total rain water that can be trapped is :"+getTotalRainWaterThatCanBeTrapped(a));
    }
}

//o/p:- The total rain water that can be trapped is :10
