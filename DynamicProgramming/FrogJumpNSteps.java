/*

Find the number of ways in which we can climb n steps with 1 step and 2 step combinations

Youtube:- https://www.youtube.com/watch?v=mLfjzJsN8us&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=3


TC : O(2^N)
SC :  O(N)

*/

import java.io.*;
import java.util.*;


public class FrogJumpNSteps{
    
    
    public static int theNumberOfWaysInWhichFrogJumpsNSteps(int n){
        
        //base case
        
        if( n == 0)
           return 0;
        if( n == 1)
          return 1;
          
        
        int left = theNumberOfWaysInWhichFrogJumpsNSteps(n-1);
        int right = theNumberOfWaysInWhichFrogJumpsNSteps(n-2);
        
        return left+right;
        
    }
    
   /*     f(3)
     f(2)   f(1)
f(1)   f(0)    

*/
    
    public static void main(String[] args){
        
        int n = 3;
        
        System.out.println(theNumberOfWaysInWhichFrogJumpsNSteps(n+1));
    }
}

//O/P:- 3 FOR N=3, [0-1, 1-2,2-3,3-4], [0-1,1-3],[0-2,2-3] , HENCE WE ARE PASSING N+1 TO FUNCTION CALL AS WE NEED TO TAKE N INCLUSIVE OF 0
