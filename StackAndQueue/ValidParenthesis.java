/*

Valid parenthesis

Youtube:- https://www.youtube.com/watch?v=wkDfsKijrZ8&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=5

TC :- O(N) where N is the size of the string
SC :- O(N) where N is the stack space used for the string
*/


import java.io.*;
import java.util.*;



public class ValidParenthesis{
    
    
    public static boolean checkIfTheGivenInputIsValidParenthesis(String s){
        
        char[] sArr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        
        //Traverse through entire string
        for(int i=0;i<sArr.length;i++){
            
            //For open parenthesis , just do push
            if(sArr[i] == '(' || sArr[i] == '{' || sArr[i] == '['){
                st.push(sArr[i]);
            }else{
                //For close parenthesis, just do pop and check
                
                //But please see if the stack is not empty before this
                if(st.empty()) 
                     return false;
                 
                char sEle = st.pop();
                if((sEle == '(' && sArr[i] == ')') ||(sEle == '[' && sArr[i] == ']') || (sEle == '{' && sArr[i] == '}')){
                      continue;
                }else{
                     return false;
                 }
                  
            }
        }
        if(st.empty())
            return true;
        else 
            return false;
    }
    
    
    public static void main(String[] args){
        
        String[] s = {"[{}]()", "[{}](","[)(]"};
        
       for(String exp : s){
        boolean isValid = checkIfTheGivenInputIsValidParenthesis(exp);
        
        System.out.println("The exp "+exp+" is "+isValid);
        }
    }
    
}

/*
o/p:-

The exp [{}]() is true
The exp [{}]( is false
The exp [)(] is false

*/
