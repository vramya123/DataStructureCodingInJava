
// Nearest Greatest to the Right or next largest number to the right 
// Youtube : https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
//TC = O(n)


import java.io.*;
import java.util.*;

public class NGR{
    
    
    public static List<Integer> getTheNearestGreatertNumberToTheRight(int[] a){
        
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i =a.length-1;i>=0;i--){
            
            //Check if stack is empty
            
            if(s.size() == 0){
                res.add(0,-1);
            
            //If top of stack is greater than a[i]
            }else if(s.size() > 0 && s.peek() > a[i]){
                res.add(0,s.peek());
            
            //If top of stack is less than a[i]
            }else if (s.size() > 0 && s.peek() <= a[i]){
                
                //pop until stack is empty or top > a[i]
                while(s.size() > 0 && s.peek() <= a[i]){
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
        
        System.out.println("The nearest greater number to the right is "+ getTheNearestGreatertNumberToTheRight(a));
    }
}

//o/p:- The nearest greater number to the right is [3, 5, 5, -1]
