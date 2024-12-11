/*   


Sieve of Eratosthenes

Given a  number n, print all prime numbers below n

TC : O (n log log n)
SC : O (n)

*/

import java.io.*;
import java.util.*;

public class SieveOfEratosthenes{
    
    
    public static void sieveOfEratosthenesToFindAllPrimeBelowN(int n){
        
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2;i <=n ;i++){
            
            if(isPrime[i]){
                
                System.out.println(i);
                //All multiples of i are marked as false 
                for(int j = i*i;j<=n;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        
    }
    
    public static void main(String[] args){
        int n = 10;
        
        sieveOfEratosthenesToFindAllPrimeBelowN(n);
    }
    /* n = 10
    
    0 1 2 3 4 5 6 7 8 9 10
    F F T T T T T T T T T
    
    i = 2; 
    just print 2 as its prime
    0 1 2 3 4 5 6 7 8 9 10
    F F T T F T F T F T F
    
    i = 3;
    just print 3 as its prime
    0 1 2 3 4 5 6 7 8 9 10
    F F T T F T F T F F F
    
    here we start from 3*3 = 9 because 6 will be already marked by i=2 bcz
    6 = (3 * 2) => will be marked when we traverse for i=2
    
    
    i=4;
    Its not prime so will not go inside the inner loop
   
    
    i = 5;
    just print 5 as its prime
    j = 5 * 5 = 25 and the inner loop will not run only as it will start from 25 but our array has only 10 entries.
    
    
    i = 6;
    Its not prime so will not go inside the inner loop
    
    i = 7
    just print 7 as its prime
    j = 7 * 7 = 49 and the inner loop will not run only as it will start from 49 but our array has only 10 entries.
    
    
    i=8;
    Its not prime so will not go inside the inner loop
     
    i=9;
    Its not prime so will not go inside the inner loop
      
    i= 10;
    Its not prime so will not go inside the inner loop
    
    */
}

/* o/p:-

2
3
5
7
/
