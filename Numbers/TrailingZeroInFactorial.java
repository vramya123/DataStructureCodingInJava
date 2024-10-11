/*

 Find the Number of Trailing Zeros in the factorial of the number
 The Trailing Zeros are the Zeros, which appear at the end of a number(factorial in that case)
 
Examples : 

Input: 5
Output: 1
// Factorial of 5 = 5*4*3*2*1 = 120, which has one trailing 0.

Input: 20
Output: 4
// Factorial of 20 = 20*19*18*.... 3*2*1 = 2432902008176640000 which has 4 trailing zeroes.

Input: 100
Output: 24


We have 2 approaches to solve the problem: Naive Approach & Efficient Approach

1) Naive Approach
A simple method is to first calculate the factorial of n, then count trailing 0s in the result (We can count trailing 0s by repeatedly dividing the factorial by 10 till the remainder is not 0).

But, this method can cause overflow for slightly bigger numbers as the factorial of a number is a big number. So, we prefer the Efficient Approach

2) Efficient Approach
The idea is to consider prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5. Our task is done if we can count the number of 5s and 2s. Consider the following examples:

n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). So a count of trailing 0s is 1.
n = 11: There are two 5s and eight 2s in prime factors of 11! (28 * 34 * 52 * 7 * 11). So the count of trailing 0s is 2.
We can easily observe that the number of 2s in prime factors is always more than or equal to the number of 5s. So if we count 5s in prime factors, we are done.

Following is the summarized formula for counting trailing 0s:

Trailing 0s in n! = Count of 5s in prime factors of n! = floor(n/5) + floor(n/25) + floor(n/125) + ....


Time Complexity: O(log5n) ie, Log to the base 5 then n

Auxiliary Space: O(1)

*/



import java.io.*;
import java.util.*;
import java.math.*;


public class TrailingZeroInFactorial{
    
    //can cause overflow for slightly bigger numbers as the factorial of a number is a big number
    public static int findTheTrailingZeroInFactorialUsingNaiveApproach(int n){
        
        if (n < 0)
         return 0;
         
        if(n <= 1)
         return 1;
         
        BigInteger res = BigInteger.ONE;
        for(int i=2;i<n;i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        
        int noOfTrailingZeroes = 0;
        while(res.remainder(BigInteger.valueOf(10)) == BigInteger.valueOf(0)){
            noOfTrailingZeroes++;
            res = res.divide(BigInteger.valueOf(10));
        }
        
        return  noOfTrailingZeroes;
    }
    
    
    //Faster efficient approach
    public static int findTheTrailingZeroInFactorialUsingEfficientApproach(int n){
        
        
        //For negative number
        if(n < 0)
         return 0;
        
        
        //For 0 or 1
        if(n <= 1)
         return 1;
        
        int noOfTrailingZeroes = 0;
        for(int i=5;i<=n;i=i*5){
            noOfTrailingZeroes += (n/i);
        }
        
        return noOfTrailingZeroes;
    }
    
    
    public static void main(String[] args){
        int n1 = 25;
        int n2 = 42;
        System.out.println("The no of 0's in 25! is "+ findTheTrailingZeroInFactorialUsingNaiveApproach(n1));
        System.out.println("The no of 0's in 42! is "+ findTheTrailingZeroInFactorialUsingEfficientApproach(n2));
        
        
    }
    
}

/*
The no of 0's in 25! is 4
The no of 0's in 42! is 9
*/
