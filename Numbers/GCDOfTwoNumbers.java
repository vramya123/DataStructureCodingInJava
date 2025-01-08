/*

GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides both of them. 

 36 = 2* 2* 3* 3
 60 =  2* 2* 3* 6

 GCD = Multiplication of common factors 
      = 2* 2* 3
      = 12

*/


import java.io.*;
import java.util.*;


public class GCDOfTwoNumbers{

    //Naive approach
    // TC = O(min(a,b))
    //We take a min number of the given pair and keep checking if it divides both numbers while we decrement after each run
    //GCD is always less than or equal to smallest of given  two numbers 
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
         return a;
         
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
    //we continuously divide the bigger number by the smaller number
    static int findTheGCDOfTwoNumbersUsingEuclideanApproachOptimized(int a , int b){
        
        //base case
        if(b == 0)
         return a;
        
        return findTheGCDOfTwoNumbersUsingEuclideanApproachOptimized(b, a%b);
        
    }

 //or

 //Ref :- https://www.youtube.com/watch?v=1xNbjMdbjug&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=8
  static int findTheGCDOfTwoNumbersUsingEuclideanApproachOptimizedIterative(int a, int b){

   while( a > 0 && b > 0 ){
    if(a > b)
       a = a%b;
      else
      b = b%a;
   }
   if(a == 0) return b;
   return a;
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
