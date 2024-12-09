/*

sieveOfEratosthenes

Given a positive integer value n. The task is to find how many numbers less than or equal to n have numbers of divisors exactly equal to 3.

Examples:

Input: n = 6
Output: 1
Explanation: The only number less than 6 with 3 divisors is 4 which has 1, 2 and 4 as divisors.


Expected Time Complexity : O(n1/2 * n1/4)
Expected Auxilliary Space :  O(1)
*/


import java.io.*;
import java.util.*;



public class SieveOfEratosthenesOrNumberWithExact3Divisiors{
    
    
    public static int numbersWithExact3Divisors(int n){
        
        
        boolean[] isPrime = sieveOfEratosthenes((int) Math.sqrt(n));
        
        //if a number i is prime, then i*i will have exact 3 divisor becuase it is divisible by 1, i and itself(i*i).
        //So we will tranverese to check prime and then increase the count variables till limit.
        
        
        int count =0;
        
        for(int i=2;i<=Math.sqrt(n);i++){
            if(isPrime[i]){
                    count++;
            }
        }
        
        return count;
    }
    
    
    public static boolean[] sieveOfEratosthenes(int limit){
        
        boolean[] isPrime = new boolean[limit+1];
        
        //Fill the array with true
        Arrays.fill(isPrime, true);
        
        //initialize 0 and 1 as false as they are not prime
        isPrime[0] = isPrime[1] = false;
        
        
        for(int i=2;i<=limit;i++){
            if(isPrime[i]){
                for(int j = i*i; j<=limit;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
    
    
    public static void main(String[] args){
        
        int n = 6;
        
        System.out.println("The number below "+n+" that has exactly 3 divisors is : "+ numbersWithExact3Divisors(n));
        
    }
    
    /*
    sieve loop :-
    
    n = 6
            0 1 2         
    isPrime[F F T]
    
    i = 2  , j = 2*2 =4  but j ! <= limit ie, 4 ! <= 3
    
    
    noOfDivisorLoop:-
            0 1 2         
    isPrime[F F T] 
    
    only one count incrrement for 2.
    
    */
    
}

//o/p:- The number below 6 that has exactly 3 divisors is : 1
