/*

Minimum element in stack using another stack ie, O(n) 

youtube:- https://www.youtube.com/watch?v=ZvaRHYYI0-4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=10
https://www.youtube.com/watch?v=ZvaRHYYI0-4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=11

*/

import java.io.*;
import java.util.*;

public class StackWithMinimumElement{
    
    static Stack<Integer> s = new Stack<Integer>();
    static Stack<Integer> ss = new Stack<Integer>();
    
    public static void push(int x){
        
      s.push(x);
      if(ss.size() == 0 || x <= ss.peek()){
             ss.push(x);
       } 
    }
    
    public static int pop(){
        if(s.size() == 0){
            return -1;
        }
        int ans = s.peek();
        if(ans ==  ss.peek()){
            ss.pop();
        }
        s.pop();
        return ans;
    }
    
    public static int getMinEle(){
        if(ss.size() == 0){
            return -1;
        }
        
        return ss.peek();
    }
    
    public static void main(String[] args){
        
        int[] a = {2,3,1,0,5,6};
        
        push(2);
        push(3);
        push(1);
        System.out.println("The min ele is :"+getMinEle());
        push(0);
        System.out.println("The min ele is :"+getMinEle());
        
        
    }
}

/*

The min ele is :1
The min ele is :0
*/
