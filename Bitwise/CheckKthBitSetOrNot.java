/*  

Check whether K-th bit is set or not


Ref :- https://www.geeksforgeeks.org/check-whether-k-th-bit-set-not/


Given a number N and a bit number K, check if the Kth bit of N is set or not. A bit is called set if it is 1. 
Note: Indexing starts with 0 from LSB (least significant bit) side in the binary representation of the number.

Input: n = 5, k = 1
Output: NOT SET
Explanation: 5 is represented as 101 in binary and bit at position 1 is not set


Input: n = 2, k = 3
Output: NOT SET
Explanation: 2 is represented as 10 in binary, all higher i.e. beyond MSB, bits are NOT SET.



TC = O(1)
Sc = O(1)

*/

import java.io.*;
import java.util.*;


public class CheckKthBitSetOrNot{
    
    
    public static void  CheckKthBitSetOrNotInGivenNumberByLeftShift(int n, int k){
        
        //By left shift logic 
        
        if( (n & (1 <<k)) > 0 )
          System.out.println("The kth bit is SET");
        else
          System.out.println("The kth bit is NOT SET");
    }
    
    
     public static void  CheckKthBitSetOrNotInGivenNumberByRightShift(int n, int k){
        
        //By Right shift logic 
        
        if((n >> k) > 0 )
          System.out.println("The kth bit is SET");
        else
          System.out.println("The kth bit is NOT SET");
    }
    
    
    public static void main(String[] args){
        
        int n = 5;
        int k = 1 ;
        
        CheckKthBitSetOrNotInGivenNumberByLeftShift(n,k);
        
        n = 2;
        k = 3 ;
        
        CheckKthBitSetOrNotInGivenNumberByRightShift(n,k);
    }
}

//o/p:- Kth bit Clear  number = 4
