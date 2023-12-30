/*
Print Fibonacci series for given number using recursion and functional recursion


Youtube:- https://www.youtube.com/watch?v=69ZCDFy-OUo&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=3

Tc :- O(N) where N is the number of times the recursion call is called

SC :- O(N) where N is the stack space
*/


import java.io.*;
import java.util.*;


public class Fibonacci{
    
    public static int fibonacciSeriesUsingFunctionRecursion(int n){
        //Base case
        if(n == 1) 
          return 1;
        
        return n * fibonacciSeriesUsingFunctionRecursion(n-1);
        
    }
    
    
     
    public static void fibonacciSeriesUsingParameterisedRecursion(int i,int val){
        //Base case
        if(i == 1) {
          System.out.println(val);
          return;
        }
        fibonacciSeriesUsingParameterisedRecursion(i-1,val*i);
        
    }
    
    public static void main(String[] args){
        
        int n = 3;
        
        System.out.println(fibonacciSeriesUsingFunctionRecursion(n));
        
        fibonacciSeriesUsingParameterisedRecursion(n,1);
        
        
    }
    
}

/*
Recursion Tree

  f(3)
  
  3*f(2)
  
  2*f(1)
  
O/p:-

6
6

*/
