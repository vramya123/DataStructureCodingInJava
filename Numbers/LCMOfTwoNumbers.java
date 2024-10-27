/*



LCM (Least Common Multiple) of two numbers is the smallest number which can be divided by both numbers. 

For example, LCM of 15 and 20 is 60, and LCM of 5 and 7 is 35.


A simple solution is to find all prime factors of both numbers, then find union of all factors present in both numbers. Finally, return the product of elements in union.

An efficient solution is based on the below formula for LCM of two numbers ‘a’ and ‘b’. 

   a x b = LCM(a, b) * GCD (a, b)

   LCM(a, b) = (a x b) / GCD(a, b)


*/


import java.io.*;
import java.util.*;


public class LCMOfTwoNumbers{
    
    
    
    
    //Naive approach
    // TC = O(a*b - max(a,b))
    //We take a max number of the given pair and keep checking if it divides both numbers while we decrement after each run
    //LCM is always greater than or equal to the largest of given two numbers
    static int findTheLCMOfTwoNumbersUsingNaiveApproach(int a, int b){
        
         //Everything divides 0
        if(a == 0)
         return b;
         
        if(b == 0)
           return b;
           
        //Initialize the max of a,b as res
        int res = Math.max(a,b);
        
        while(true ){
            if(res % a == 0 && res % b ==0)
              break;
            res++;
        }
        
        return res;
    }
    
    
    
    //Euclidean algorithm 
    //a*b = GCD(a,b) * LCM(a,b)
    // LCM (a,b) = a*b /GCD(a,b)
    // TC = O(log(min(a,b)))
    //time complexity of the algorithm increases linearly as the terms grow exponentially hence the time complexity would be log(min(a,b)).
    //we continuously divide the bigger number by the smaller number
    static int findTheGCDOfTwoNumbersUsingEuclideanApproachOptimized(int a , int b){
        
        //base case
        if(b == 0)
         return a;
        
        return findTheGCDOfTwoNumbersUsingEuclideanApproachOptimized(b, a%b);
        
    }
    
    static int findTheLcmUsingGCD(int a, int b){
        
        
        return (a * b) / findTheGCDOfTwoNumbersUsingEuclideanApproachOptimized(a,b);
    }
    
    public static void main(String[] args){
        
        int a= 98, b = 56;
        
        System.out.println("The LCM for "+a+" and "+b+" using naive approach is "+findTheLCMOfTwoNumbersUsingNaiveApproach(a,b));
        System.out.println("The LCM  for  "+a+" and "+b+" is using optimized euclidean approach "+findTheLcmUsingGCD(a,b));
    }
}

/*
o/p:-
 The LCM for 98 and 56 using naive approach is 392
The LCM  for  98 and 56 is using optimized euclidean approach 392

*/
