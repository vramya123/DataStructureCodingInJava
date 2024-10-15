/*

GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides both of them. 


*/


import java.io.*;
import java.util.*;


public class GCDOfTwoNumbers{
    
    
    
    
    //Naive approach
    // TC = O(min(a,b))
    //We take a min number of the given pair and keep checking if it divides both numbers while we decrement after each run
    static int findTheGCDOfTwoNumbersUsingNaiveApproach(int a, int b){
        
         //Everything divides 0
        if(a == 0)
         return b;
         
        if(b == 0)
           return b;
           
        //Initialize the min of a,b as res
        int res = Math.min(a,b);
        
        while(res != 1 ){
            if(a% res == 0 && b% res ==0)
              break;
            res--;
        }
        
        return res;
    }
    
    
    
    //Euclidean algorithm by subtraction
    //GCD(a,b) =  GCD(a-b,b) if b < a
    //TC = O(max(a,b))
    
    static int findTheGCDOfTwoNumbersUsingEuclideanApproach(int a, int b){
        
        //Everything divides 0
        if(a == 0)
         return b;
         
        if(b == 0)
           return b;
           
        while ( a != b){
            if(a > b){
                a = a-b;
            }else{
                b = b-a;
            }
        }
        
        return a;
    }
    
    // TC = O(log(min(a,b)))
    //time complexity of the algorithm increases linearly as the terms grow exponentially hence the time complexity would be log(min(a,b)).
    static int findTheGCDOfTwoNumbersUsingEuclideanApproachOptimized(int a , int b){
        
        //base case
        if(b == 0)
         return a;
        
        return findTheGCDOfTwoNumbersUsingEuclideanApproachOptimized(b, a%b);
        
    }
    
    public static void main(String[] args){
        
        int a= 98, b = 56;
        
        System.out.println("The GCD for "+a+" and "+b+" using naive approach is "+findTheGCDOfTwoNumbersUsingNaiveApproach(a,b));
        System.out.println("The GCD for  "+a+" and "+b+"  using euclidean approach is "+findTheGCDOfTwoNumbersUsingEuclideanApproach(a,b));
        System.out.println("The GCD for  "+a+" and "+b+" is using optimized euclidean approach "+findTheGCDOfTwoNumbersUsingEuclideanApproachOptimized(a,b));
    }
}

/*
o/p:-
The GCD for 98 and 56 using naive approach is 14
The GCD for  98 and 56  using euclidean approach is 14
The GCD for  98 and 56 is using optimized euclidean approach 14
*/
