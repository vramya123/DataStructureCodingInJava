/* 

Program to clear K-th bit of a number N

Given a number N, the task is to clear the K-th bit of this number N. 
If K-th bit is 1, then clear it to 0 and if it is 0 then leave it unchanged.

Input: N = 5, K = 1
Output: 4
5 is represented as 101 in binary
and has its first bit 1, so clearing
it will result in 100 i.e. 4.


Method:-

Since bitwise AND of any bit with a reset bit results in a reset bit, i.e.


n = 5 , k =1 

     5 =   101  , 1<<k-1 = 1 << 0  = 001 , ~ (001) = 110

        101
(AND)   110
-------------------------
        100                 4 
-------------------------


TC = O(1)
SC = O(1)


*/


import java.io.*;
import java.util.*;


public class ClearKthBit{
    
    
    public static int  ClearKthBitInGivenNumber(int n, int k){
        
        return n & ~(1 << (k-1));
    }
    
    
    public static void main(String[] args){
        
        int n = 5;
        int k = 1 ;
        
        System.out.println("Kth bit Clear  number = " +ClearKthBitInGivenNumber(n,k));
    }
}

//o/p:- Kth bit Clear  number = 4
