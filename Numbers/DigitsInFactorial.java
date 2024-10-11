/*

Given an integer N. Find the number of digits that appear in its factorial. 
Factorial is defined as, factorial(n) = 1*2*3*4……..*N and factorial(0) = 1.

Input: N = 5
Output: 3
Explanation: Factorial of 5 is 120.
Number of digits in 120 is 3 (1, 2, and 0)

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)


Explanation:
Mathematical Approach: Instead of calculating the factorial directly, this program uses the property of logarithms to determine the number of digits. The number of digits in a number (x) is given by (\lfloor \log_{10}(x) \rfloor + 1).

Logarithmic Sum: By summing the logarithms of all integers from 2 to (N), you can find the logarithm of (N!). This avoids the need to compute the potentially very large number (N!) directly.

Time Complexity: This approach has a time complexity of (O(N)), but it is much faster in practice because it avoids the large number multiplications.


The number of digits in the factorial of N grows with N, but the relationship isn't linear. In fact, it's more closely related to the logarithmic function. Mathematically, the number of digits d in N! can be approximated by the formula:

d≈⌊log10(N!)⌋+1

*/



import java.io.*;
import java.util.*;
import java.math.*;


public class DigitdInFactorial{
    
    //Slower for larger number due to large number multiplication
    public static int findTheNoOfDigitsInFactorialUsingBigInt(int n){
        
        if (n < 0)
         return 0;
         
        if(n <= 1)
         return 1;
         
        BigInteger res = BigInteger.ONE;
        for(int i=2;i<n;i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        
        return  res.toString().length();
    }
    
    
    //Faster 
    public static int findTheNoOfDigitsInFactorialUsingLog(int n){
        
        
        //For negative number\
        if(n < 0)
         return 0;
        
        
        //For 0 or 1
        if(n <= 1)
         return 1;
        
        double digit = 0;
        
        for (int i = 2; i <= n ; i++){
            
            digit += Math.log10(i);
        }
        
        return (int) Math.floor(digit)+1;
    }
    
    
    public static void main(String[] args){
        
        int n2 = 42;
        int n1 = 25;
        
        
        System.out.println("The no of digits in 25! is "+ findTheNoOfDigitsInFactorialUsingBigInt(n1));
        System.out.println("The no of digits in 42! is "+ findTheNoOfDigitsInFactorialUsingLog(n2));
        
        
    }
    
}

/*
The no of digits in 25! is 24
The no of digits in 42! is 52
*/
