/*

PascalTriangle

0-           1
1-         1     1
2-        1    2     1
3-    1     3     3      1
4-  1   4      6     4      1

1st and last element is always 1 in a given row. 

The number in between is sum of the last row two number ie, in row 4, the number [4][1] = [3][0] + [3][1] => 4 = 1 + 3


youtube:- https://www.youtube.com/watch?v=bR7mQgwQ_o8

*/

import java.io.*;
import java.util.*;

public class PascalTriangle{
    
    //TC = O(r)
    public static long getTheNumberAtLocationInThePascalTriangle(int n, int r){
        
        /*
          row-1
             C    = R!/C! * (R-C)!  is the formula to get a number at a location,but its costly operation when n is big
              col-1
        
        eg :5
             C   = 5!/2! * (5-2)! = 5*4*3*2*1 / (2*1) * (3*2*1) = 5*4 /2*1 = 5/1 * 4/2 
              2 
                 = (n-0)/(0+1) * (n-1)/(i+1) where 0 <= i < r
        */
        
        long res = 1;
        
        for(int i=0;i<r;i++){
             res = res * (n-i);
             res = res/(i+1);
        }
        
        return res;
        
    }
    
    //TC = O(r)
    /*    0   1      2           3      4
      5-  1   4      6           4      1    => This is 4th row if 0 convention, but we are taking 1 convention for rows and 0 convention for col
          |    |     |           |      |
    ans   1   4C1   4C2         4C3     1     
               |     |           |
              (4/1) (4/1)*(3/2) (4/1)*(3/2)*(2/1)
    
    */
    
    //TC = O(n)
    public static void printEntireRowInThePascalTriangle(int n){
        int ans = 1;
        System.out.print(ans+" ");
        for(int i=1;i<n;i++){
            ans = ans * (n-i);
            ans = ans/(i);
            System.out.print(ans+" ");
        }
        System.out.println();
    }
    
    //TC = O(n)* O(n) = O (n2)
    public static void printEntirePascalTriangle(int n){
        for(int i=1;i<=n;i++){ //note loop starts from 1 as we are using printEntireRowInThePascalTriangle which refers row from 1
            printEntireRowInThePascalTriangle(i);
        }
    }
    
    
    public static void main(String[] args){
        
     
        int n = 5;
        int r = 3;
        
        System.out.println("The Number At Location"+n +","+r+" In The PascalTriangle is "+getTheNumberAtLocationInThePascalTriangle(n-1,r-1));
        
        
        System.out.println("========================");
        
        System.out.println("The "+n +" row in The PascalTriangle is :");
        printEntireRowInThePascalTriangle(n); //notice we pass n and not n-1
        
        System.out.println("========================");
        
        System.out.println("The "+n +" row  PascalTriangle is :");
        printEntirePascalTriangle(n); //notice we pass n-1 and not n
    }
}

/* o/p:-
The Number At Location5,3 In The PascalTriangle is 6
========================
The 5 row in The PascalTriangle is :
1 4 6 4 1 
========================
The 5 row  PascalTriangle is :
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 */

