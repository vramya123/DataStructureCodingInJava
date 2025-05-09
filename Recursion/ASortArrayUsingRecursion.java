/*
Sort an array using recursion

youtube: https://www.youtube.com/watch?v=AZ4jEY_JAVc&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=6


*/

import java.io.*;
import java.util.*;


public class ASortArrayUsingRecursion{
    
    
    public static void sortAnArray(List<Integer> a){
        
        //Base
        if(a.size() == 1){
            return;
        }
        
        //Hypothesis
        Integer ele = a.get(a.size()-1);
        a.remove(a.size()-1);
        sortAnArray(a);
        
        //Induction
        insert(a,ele);
        
    }
    
    
    
    public static void insert(List<Integer> a, Integer ele){
        
        //Base case
        if(a.size() == 0 || a.get(a.size()-1) <= ele){
            a.add(ele);
            return;
        }
        
        //Hypothesis
        Integer element = a.get(a.size()-1);
        a.remove(element);
        insert(a,ele);
        
        //Induction
        a.add(element);
    }
    
    
    public static void main(String[] args){
        
        List<Integer> ls = new ArrayList<>();
        ls.add(2);
        ls.add(8);
        ls.add(7);
        ls.add(0);
        ls.add(1);
        
        
        sortAnArray(ls);
        
        
        ls.forEach(System.out::print);
        
    }
}

//o/p:- 01278
