/*



Given a natural number n, print all distinct divisors of it in ascending order



TC :- O(sqrt(n))
SPC : O(1)

*/


import java.io.*;
import java.util.*;

public class DivisorsOfGivenNumber{
    
    /*
    
    n = 5
    
    i = 1 , i*i < 5,  5%1 ==0 , print 1
    i = 2 , i*i < 5,  5%2 !=0  
    i = 3 , i*i !< 5 
    
    
    i = 3, i >=1 , 5%3 != 0
    i = 2, i >=1 , 5%2 != 0
    i = 1 , i >=1 , 5%1 == 0 print 5/1 = 5
    
    
    Striver:-
    
    36
    
    1 * 36       i * n/i = 1 * 36/1 = 1 * 36 , so second factor can be obtainged by dividing n by i 
    2 * 18
    3 * 12
    4 * 9
    6 * 6 ========== sqrt(36) After this point the factors just repeat in incraesing fashion of n/i 
    9 * 4
    12 * 3 
    18 * 2 
    36 * 1
    
    */
    public static void allDivisorsOfGivenNumber(int n){
        
        int i ;
        
        //Print all divisors from 1(inclusive) to sqrt(n)(exclusive)
        
        for(i=1 ;i *i < n;i++){
            
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
        
        //Print all divisors from sqrt(n)(inclusive)  to 1 (inclusive) )
        
        for(;i >=1;i--){
            if( n % i == 0){
                System.out.print(n/i +" ");
            }
        }
        
    }
    
    
    public static void main(String[] args){
        
        int n = 161;
        
        allDivisorsOfGivenNumber(n);
    }
}

//o/p:- 1 7 23 161 
