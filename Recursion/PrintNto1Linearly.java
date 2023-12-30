/*

Print N to 1 linearly using recusrion and bactracking without using i-1 in the function implementation

Youtube:- https://www.youtube.com/watch?v=un6PLygfXrA&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=2

TC:- O(N) where is the number of times the recursion call is made

*/


import java.io.*;
import java.util.*;


public class PrintNto1Linearly{
    
    
    public static void printNumberLinearly(int i, int n){
        
        //base case
        if(i >n)
         return;
         
        printNumberLinearly(i+1,n);
        System.out.println(i);
    }
    
    /* Recursion Tree for n = 3
         f(1,3)
         
         f(2,3)
         
         f(3,3)
          
         f(4,3)
    
    */
    
    public static void main(String[] args){
        
        int n = 3;
        
        printNumberLinearly(1,n);
    }
}

/*
 o/p:-
 
3
2
1
*/
