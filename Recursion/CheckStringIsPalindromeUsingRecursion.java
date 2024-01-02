// Check a string is palindrome using recursion

//Youtube :- https://www.youtube.com/watch?v=twuC1F6gLI8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=5

//TC : O(N)


import java.io.*;
import java.util.*;


public class CheckStringIsPalindromeUsingRecursion{
     static int n;
     static String str;
     
     public static boolean checkStringIsPalindrome(String s){
         str = s;
         n = s.length();
         return checkIfPalindrome(0);
     }
     
     public static boolean checkIfPalindrome(int i){
         //Base case
         if(i >= n/2)
            return true;
         
         /*
         Single index approach to fetch index
         
           s = m a d a m
               0 1 2 3 4
               
               i = 0   j = n-i-1 = 5-0-1 = 4 ( 1st and last character index)
               i = 1   j = n-i-1 = 5-1-1 = 3 ( 2nd  and last but one character index)        
         */
         if(str.charAt(i) != str.charAt(n-i-1))
            return false;
        
         return checkIfPalindrome(i+1);
     }
     
     public static void main(String[] args){
         String[] s = { "madam", "mada"};
         
         for(int i=0;i<s.length;i++){
             System.out.println(s[i]+ " is palindrome:"+ checkStringIsPalindrome(s[i]));
         }
     }
}

/* o/p:-
madam is palindrome:true
mada is palindrome:false
*/
