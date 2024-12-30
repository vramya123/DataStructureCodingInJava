/*

Toggling k-th bit of a number

Ref : https://www.geeksforgeeks.org/toggling-k-th-bit-number/

For a given number n, if k-th bit is 0, then toggle it to 1 and if it is 1 then, toggle it to 0.


Input : n = 6, k = 1
Output : 7
6 is represented as 110 in binary and has its first bit 0, so toggling  it will result in 111 i.e. 7.

Method :

n = 6 =>  110
k = 1 => 1 << (k-1), 001

n ^ ( 1<<(k-1)) => 110
                ^  001
                -----------
                   111   => 7
                ------------
TC = O(1)
SC = O(1)


*/


import java.io.*;
import java.util.*;


public class ToggleKthBit{
    
    
    public static int  ToggleKthBitInGivenNumber(int n, int k){
        
        return n ^ (1 << (k-1));
    }
    
    
    public static void main(String[] args){
        
        int n = 6;
        int k = 1 ;
        
        System.out.println("Kth bit Toggle  number = " +ToggleKthBitInGivenNumber(n,k));
    }
}

//o/p:- Kth bit Toggle  number = 7

