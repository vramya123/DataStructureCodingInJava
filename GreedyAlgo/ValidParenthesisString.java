/*

Valid parenthesis string

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true

youtube:- https://www.youtube.com/watch?v=cHT6sG_hUZI&list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea&index=12

Simple logic:-

Keep counter which is incremented as we traverse the string
1) ( => +1
2) ) => -1
3) *  => +1, -1, 0
 
*/


import java.io.*;
import java.util.*;

public class ValidParenthesisString{
    
    //TC = O(3^N)  SC = O(N) using recursion
    public static boolean checkIftheGivenStringHasValidParenthesis(String s, int index, int counter){
        
        if(counter < 0)
          return false;
        
        if(index == s.length())
          return (counter == 0);
          
        
        if(s.charAt(index) == '(')
          return checkIftheGivenStringHasValidParenthesis(s, index+1, counter+1);
        
        if(s.charAt(index) == ')')
          return checkIftheGivenStringHasValidParenthesis(s, index+1, counter-1);
          
        return checkIftheGivenStringHasValidParenthesis(s, index+1, counter+1) ||
          checkIftheGivenStringHasValidParenthesis(s, index+1, counter-1) || 
          checkIftheGivenStringHasValidParenthesis(s, index+1, counter);
    }
    
    //TC = O(N)  SC = O(1)
     public static boolean checkIftheGivenStringHasValidParenthesisOptimized(String s){
         
         int min = 0;
         int max = 0;
         
         //traverse the string
         
         for(int i=0;i<s.length();i++){
             
             if(s.charAt(i) == '('){
                 min= min+1;
                 max = max+1;
             }else if(s.charAt(i) == ')'){
                 min = min-1;
                 max = max-1;
             }else if(s.charAt(i) == '*'){
                 
                 // for i = 2, for * the possible values are 2+1 , 2+0, 2-1 => 3,2,1, so min = 2-1 and max = 2+1
                 min = min-1;
                 max = max+1;
             }
             if(min < 0)
                min = 0;
             if(max < 0)  // s = ))()  min =-1, max =-1
                return false;
         }
         return (min ==0);
         
     }
        
    
    public static void main(String[] args){
        
        String str = ")*))";
        
        System.out.println("The given string contains valid parenthesis:"+ checkIftheGivenStringHasValidParenthesis(str,0,0));
        
        System.out.println("The given string contains valid parenthesis:"+ checkIftheGivenStringHasValidParenthesisOptimized(str));
    }
}

/*

The given string contains valid parenthesis:false

*/
