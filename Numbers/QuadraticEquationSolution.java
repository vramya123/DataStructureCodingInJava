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
