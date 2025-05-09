//Maximum number of consecutive 1's

// youtube : https://www.youtube.com/watch?v=bYWLJb3vCWY&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=3

//TC : O(N)


import java.io.*;
import java.util.*;


public class MaxConsecutiveOnes{
    
    
    public static int findMaxNumberOfOnes(int[] a){
        
        int max = 0;
        int count = 0;
        
        for(int i=0;i<a.length;i++){
            if(a[i] == 1){
                count++;
                max = Math.max(max,count);
            }else{
                count = 0;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args){
        
        int[] a = {1,1,0,0,1,1,1,0,0,1,1,1,1};
        
        System.out.println("The max consecutive ones is : "+findMaxNumberOfOnes(a));
    }
}

//o/p:- The max consecutive ones is : 4
