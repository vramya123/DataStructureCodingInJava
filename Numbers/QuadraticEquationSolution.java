/*  Quadratic equation solution */


import java.io.*;
import java.util.*;


public class QuadraticEquationSolution{
    
    
    public static List<Double> getQuadraticEquationSolution(int a, int b, int c){
        
        List<Double> res = new ArrayList<>();
        int discriminator =(b*b) - (4*a*c);
        
        if(discriminator == 0){
            
            System.out.println("The roots are real and equal");
            double r1 = -b/ (2*a);
            res.add(r1);
            res.add(r1);
        }else if (discriminator > 0){
            
            System.out.println("The roots are real and distinct");
            double r1 = (-b + Math.sqrt(discriminator))/(2*a);
            double r2 = (-b - Math.sqrt(discriminator))/ (2*a);
            if( r1 > r2){
                 res.add(r1);
                 res.add(r2);
            }else{
                res.add(r2);
                res.add(r1);
            } 
        }else{
            
            System.out.println("the roots are imaginary and distinict");
            double r1 = -b /(2*a);
            double r2 = Math.sqrt(- discriminator )/(2*a);
            res.add(r1);
            res.add(r2);
        }
     
     return res;   
    }
    
    
    public static void main(String[] args){
        
        int a = 2, b = 5, c = 3;
        
        List<Double> res = getQuadraticEquationSolution(a,b,c);
        
        res.forEach((n) ->  System.out.println("The root is :"+n));
    }
}

/* The roots are real and distinct
The root is :-1.0
The root is :-1.5
*/

/*  Varaiation from GFG

Given a quadratic equation ax2 + bx + c = 0, find its roots. If the roots are imaginary, return only one integer -1. Always return the roots as the greatest integers less than or equal to the actual roots, with the maximum root first followed by the minimum root.

Note: If roots are imaginary, the generated output will display "Imaginary"

*/



// User function Template for Java

class Solution {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
       ArrayList<Integer> res = new ArrayList<>();
        Integer d = (b*b) - (4*a*c);
        
        if(d == 0){
            
            
            Integer r1 = -b/ (2 * a);
            res.add(r1);
            res.add(r1);
            
            
        }else if (d > 0){
            
            double dsqrt = Math.sqrt(d);
            Integer r1 =   (int) Math.floor((-b + dsqrt ) / (2*a));
            Integer  r2 =  (int) Math.floor((-b - dsqrt) / (2*a));
            if( r1 > r2){
                 res.add(r1);
                 res.add(r2);
            }else{
                res.add(r2);
                res.add(r1);
            } 
        }else{
            
             res.add(-1);
        }
     
     return res;   
    }
}
