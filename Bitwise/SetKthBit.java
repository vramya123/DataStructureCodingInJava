/*

Set the K-th bit of a given number

Given a number n and a value k. From the right, set the kth bit in the binary representation of n. 
The position of LSB(or last bit) is 0, second last bit is 1 and so on. 
Also, 0 <= k < x, where x is the number of bits in the binary representation of n.

Ref :- https://www.geeksforgeeks.org/set-k-th-bit-given-number/

Input : n = 10, k = 2
Output : 14
10 = (1010)
Now, set the 2nd bit from right.
14 = (1110)
2nd bit has been set


Method:- 

10 = 1010 = n , k = 2

      1010
(XOR) 0100  [ 0001 ( ie, 1 in binary) left shift by k, so we get 1 in kth place which is 2^k ie, 2^2 = 4 ie, 0100]
-------------
      1110    = 14
-------------

TC = O(1)
SC = O(1)


*/


import java.io.*;
import java.util.*;


public class SetKthBit{
    
    
    public static int  setKthBitInGivenNumber(int n, int k){
        
        return ( 1 << k | n);
    }
    
    
    public static void main(String[] args){
        
        int n = 10;
        int k = 2;
        
        System.out.println("Kth bit set number = " +setKthBitInGivenNumber(n,k));
    }
}

//o/p:- Kth bit set number = 14
