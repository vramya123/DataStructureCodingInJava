/*

Prime factors for a given number



Note:-

The prime factors multiplication results in the number itself.
eg:-

12

prime factors :- 2 2 3  (2*2*3 = 12)
2 comes twice here because the first occurrence shows that 2 divides 12, 
the second occurrence of 2 indicates that multiple of 2 ie, 2^2 = 4 also divides 12.
*/

import java.io.*;
import java.util.*;

public class PrimeFactors{
    
    
    
    //TC :- O(n log(n))
    public static void printPrimeFactorsForAGivenNumberUsingNativeApproach(int n){
        
        if(n < 2){
            System.out.println("No prime numbers");
        }
        
        //traverse from 2 to all numbers and check
        for(int i=2;i<n;i++){
            if(isPrime(i)){
                int x = i;
                while(n%x == 0){
                    System.out.print(i + " ");
                    x = x * i ;
                }
            }
        }
        System.out.println();
    }
    
    
    /*
    The efficient solution is based on below two rules :-
    1) every number can be written as the multiplication of the powers of prime factors
    eg:-  12 = 2^2  * 3
    
    2) Every number divisors occurs in pair as follows:-
    eg:- 12
        ( 2, 3) (4, 3) (6, 2) (12, 1)
    
    Here if we take (x,y) such that x*y = n, then if
                     x <= y
                     x*x <= n
                     x <= sqrt(n)
    */ 
    
    
    //TC = O(sqrt(n))
    public static void printPrimeFactorsForAGivenNumberUsingEfficientApproach(int n){
        
        if(n <=1)
           return;
        
        //Handle all divisors that are visible by 2
        while( n % 2 == 0){
            System.out.print(2 +" ");
            n = n/2;
        }
        
        //Handle all divisors that are visible by 3
        while( n %3 == 0){
            System.out.print(3 +" ");
            n = n/3;
        }
        
        //Check from 5 skipping all multiples of 2 and 3 till sqrt(n)
        for(int i =5; i * i <= n;i=i+6){
            while( n%i == 0){
                System.out.print(i +" ");
                n = n/i;
            }
            
            while(n%(i+2) ==0){
                System.out.print((i+2) + " ");
                n = n/(i+2);
            }
        }
        //For last divisor of the number n which is a prime number of power 1 ie, not visible by anything else
        if( n > 3){   
            System.out.println(n);
        }
    }
    
    
    public static boolean isPrime(int n){
         
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
        
        int n = 12;
        
        printPrimeFactorsForAGivenNumberUsingNativeApproach(n);
        
        int m = 450;
        
        printPrimeFactorsForAGivenNumberUsingEfficientApproach(m);
    }
}

/* 
output:-

2 2 3

2 3 3 5 5 

*/
