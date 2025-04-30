/*

Minimum element in stack using only variable ie, O(1) 

youtube:- https://www.youtube.com/watch?v=ZvaRHYYI0-4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=10
https://www.youtube.com/watch?v=ZvaRHYYI0-4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=11

*/

import java.io.*;
import java.util.*;

public class StackWithMinimumElementUsingVariable{
    
    static Stack<Integer> s = new Stack<Integer>();
    static int minEle;
    
    public static void push(int x){
      if(s.size() ==0){
          s.push(x);
          minEle = x;
      }else{
          if(x > minEle){
              s.push(x);
          }else{
              s.push(2*x-minEle);
              minEle = x;
          }
      }
       
    }
    
    public static int pop(){
        if(s.size() == 0){
            return -1;
        }else{
            int ans = s.peek();
            if(ans >= minEle){
                s.pop();
            }else{
                ans = minEle;
                minEle = 2*minEle-ans;
                s.pop();
            }
            return ans;
        }
    }
    
    public static int getMinEle(){
        if(s.size() == 0){
            return -1;
        }
        
        return minEle;
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
