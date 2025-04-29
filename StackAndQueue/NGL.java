
// Nearest Greatest to the left or next largest number to the left 
// Youtube : https://www.youtube.com/watch?v=T5s96ynzArg&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=4
//TC = O(n)


import java.io.*;
import java.util.*;

public class NGL{
    
    
    public static List<Integer> getTheNearestGreatertNumberToTheLeft(int[] a){
        
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i =0;i< a.length;i++){
            
            //Check if stack is empty
            
            if(s.size() == 0){
                res.add(-1);
            
            //If top of stack is greater than a[i]
            }else if(s.size() > 0 && s.peek() > a[i]){
                res.add(s.peek());
            
            //If top of stack is less than a[i]
            }else if (s.size() > 0 && s.peek() <= a[i]){
                
                //pop until stack is empty or top > a[i]
                while(s.size() > 0 && s.peek() <= a[i]){
                    s.pop();
                }
                
                if(s.size() == 0){
                    res.add(-1);
                }else{
                    res.add(s.peek());
                }
            }
            s.push(a[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args){
        
        int[] a = {2 , 3 , 0, 5};
        
        System.out.println("The nearest greater number to the left is "+ getTheNearestGreatertNumberToTheLeft(a));
    }
}

//o/p:- The nearest greater number to the left is [-1, -1, 3, -1]
