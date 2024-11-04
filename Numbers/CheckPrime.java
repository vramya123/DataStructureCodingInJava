/*

Find the prime for a given number

A number that is visible by 1 and itself.
All prime numbers are odd except 2.

*/


import java.io.*;
import java.util.*;


public class CheckPrime{
    
    /*Naive approach
    
    All  divisors appear in pairs ie,
    
    30 = (1,30) (2,15) 
    
    So if (x,y) is a pair then x*y = n.
    Suppose  x <= y , then
            x * x <= n
            x <= sqrt(n)
    
    
    Thus we can traverse from 3 to sqrt(n) because we will always find the smaller number in a divisor pair which will
    prove that the given number has a divisor other than 1 and itself. 
    
    This also helps the search space when we have big numbers
    
    
    TC = O(sqrt(n))
    SC = O(1)
    */
    public static boolean checkIfGivenNumberIsPrimeNaiveApproach(int n){
        
        //Negative number or 1
        if(n <= 1)
          return false;
         
        //The two consecutive prime numbers
        if( n ==2 || n == 3)
           return true;
        
        for(int i = 4;i <= Math.sqrt(n) ;i++){
            if(n % i == 0)
             return false;
        }
        
        
        return true;
        
    }
    
    
    /* Efficient approach
    
    Here we rule out 2 and the multiples of 2, 3 and the multiples of 3 and then search in the rest of the space to see
    if the given number has a divisor.
    
    TC = O (sqrt(n))
    SC = O(1)
    
    */
    
    public static boolean checkIfGivenNumberIsPrimeEfficientApproach(int n){
         
        //Negative number or 1
        if(n <= 1)
          return false;
         
        //The two consecutive prime numbers
        if( n ==2 || n == 3)
           return true;
           
        //Ruling out the multiples of 2 and 3 in search space
        if( n%2 == 0  || n%3 == 0)
           return false;
        
        for(int i =5;i <= Math.sqrt(n) ;i = i+6){
            if(n % i == 0 || n % (i+2) == 0)
              return false;
        }
        
        return true;
        
    }
    
    
    public static void main(String[] args){
        
        int n = 689805;
        
        // Start measuring execution time
        long startTime = System.nanoTime();
       
        System.out.println("Naive approach : The given number "+ n +" is :"+checkIfGivenNumberIsPrimeNaiveApproach(n));
        
         // Stop measuring execution time
        long endTime = System.nanoTime();

        // Calculate the execution time in milliseconds
        long executionTime
            = (endTime - startTime) / 1000000;
            
        System.out.println("The execution time in Naive approach is :"+executionTime+"ms");
        
        
        // Start measuring execution time
        long startTime2 = System.nanoTime();
        
        System.out.println("Efficient Approach : The given number "+ n +" is :"+checkIfGivenNumberIsPrimeEfficientApproach(n));
    
         // Stop measuring execution time
        long  endTime2 = System.nanoTime();

        // Calculate the execution time in milliseconds
         long executionTime2
            = (endTime2 - startTime2) / 1000000;
            
        System.out.println("The execution time in Efficient  approach is :"+executionTime2+"ms");
    }
    
}


/* o/p:-

  Naive approach : The given number 689805 is :false
The execution time in Naive approach is :36ms
Efficient Approach : The given number 689805 is :false
The execution time in Efficient  approach is :0ms

  */
