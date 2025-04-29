
// Nearest Smallest to the Right or next smallest number to the right 
// Youtube : https://www.youtube.com/watch?v=nc1AYFyvOR4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6
//TC = O(n)


import java.io.*;
import java.util.*;

public class NSR{
    
    
    public static List<Integer> getTheNearestSmallestNumberToTheRight(int[] a){
        
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i =a.length-1;i>=0;i--){
            
            //Check if stack is empty
            
            if(s.size() == 0){
                res.add(0,-1);
                
            }else if(s.size() > 0 && s.peek() < a[i]){
                res.add(0,s.peek());
                
            }else if (s.size() > 0 && s.peek() >= a[i]){
                
                while(s.size() > 0 && s.peek() >= a[i]){
                    s.pop();
                }
                
                if(s.size() == 0){
                    res.add(0,-1);
                }else{
                    res.add(0,s.peek());
                }
            }
            s.push(a[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args){
        
        int[] a = {2 , 3 , 0, 5};
        
        System.out.println("The nearest smallest number to the right is "+ getTheNearestSmallestNumberToTheRight(a));
    }
}

//o/p:- The nearest smallest number to the right is [0, 0, -1, -1]
