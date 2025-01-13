/*


Stack invocations

1) Parameterized

2) Functional

Ex:- Sum of n numbers using recursion

*/

import java.io.*;
import java.util.*;

public class RecusrionInvocationsForSummation{
    
    /*
    Recursion tree
    
    f(5,0)
    
    f(4,5)
    
    f(3,9)
    
    f(2,12)
    
    f(1,14)
    
    f(0,15)
    
    */
    public static void  sumUsingParameterizedRecusrion(int n, int sum){
    
        //Base Case
        if(n < 1){
            System.out.println("The sum is "+ sum);
            return;
        }
        sumUsingParameterizedRecusrion(n-1,sum+n);
    }
    
    /* 
    
    Recusrion Tree
    
     f(5)  = 15
     
     5 + f(4)  5 + 10 = 15
     
     4 + f(3)  4 + 6 = 10 
     
     3 + f(2)  3+ 3 = 6
     
     2 + f(1)   2 + 1 = 3
     
     1 + f(0) = 1+ 0 = 1
    
    */
    public static int sumUsingFunctionalRecusrion(int n){
    
    //Base case
    if( n == 0){
        return 0;
    }
    
    return n + sumUsingFunctionalRecusrion(n-1);
    }
    
    public static void main(String[] args){
        
        int n = 5;
        
        sumUsingParameterizedRecusrion(5,0);
        
        System.out.println("The sum is "+ sumUsingFunctionalRecusrion(n));
    }
    
}

/*

The sum is 15
The sum is 15


*/
