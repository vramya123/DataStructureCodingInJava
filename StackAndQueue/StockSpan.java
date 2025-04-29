// Stock Span problem 

// Youtuibe :- https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6

/*

Question :- https://www.geeksforgeeks.org/the-stock-span-problem/


The stock span problem is a financial problem where we have a series of daily price quotes for a stock denoted by an array arr[] 
and the task is to calculate the span of the stock’s price for all days. 

The span of the stock’s price on ith day represents the maximum number of consecutive days leading up to ith day 
(including the current day) where the stock’s price was less than or equal to its price on day i.

Examples:

Input: arr[] = [100, 80, 60, 70, 60, 75, 85]
Output: [1, 1, 1, 2, 1, 4, 6]
Explanation: 
Traversing the given input span 100 is greater than equal to 100 and there are no more elements behind it so 
the span is 1, 80 is greater than equal to 80 and smaller than 100 so the span is 1, 60 is greater than equal 
to 60 and smaller than 80 so the span is 1, 70 is greater than equal to 60,70 and smaller than 80 so the span 
is 2 and so on.  Hence the output will be 1 1 1 2 1 4 6.


*/

//Hint : Nearest Greater number to the left and i - index of NGL

import java.io.*;
import java.util.*;

class Pair{
    
    public int val;
    public int index;
    
    public Pair(int val, int index){
        this.val = val;
        this.index = index;
    }
}

public class StockSpan{
    
    
    public static List<Integer> stockSpanToGetConsecutiveDaysPriceLessThanGivenDay(int[] a){
        
        List<Integer> res = new ArrayList<>();
        List<Integer> finalres = new ArrayList<>();
        Stack<Pair> s = new Stack<>();
        
        for(int i =0;i<a.length;i++){
            
            if(s.size() == 0){
                res.add(-1);
            }else if(s.size() > 0 && s.peek().val > a[i]){
                res.add(s.peek().index);
            }else if(s.size() > 0 && s.peek().val <= a[i]){
                
                while( s.size() > 0 && s.peek().val <= a[i]){
                    s.pop();
                }
                
                if(s.size() ==0){
                    res.add(-1);
                }else{
                    res.add(s.peek().index);
                }
            }
            s.push(new Pair(a[i],i));
        }
        
        //Minus the base index with NGL idex to get teh count
        
        for(int i =0;i< res.size();i++){
            finalres.add(i-res.get(i));
        }
        
        return finalres;
    }
    
    public static void main(String[] args){
         int arr[] = {100, 80, 60, 70, 60, 75, 85};
         
         System.out.println("The stock span solution is "+ stockSpanToGetConsecutiveDaysPriceLessThanGivenDay(arr));
        
    }
}

//o/p:- The stock span solution is [1, 1, 1, 2, 1, 4, 6]
