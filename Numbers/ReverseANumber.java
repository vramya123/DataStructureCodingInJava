/*

Reverse a number such taht the trailing zeroes of it are ignored. 
n = 10400, res = 401


*/




import java.io.*;
import java.util.*;


public class ReverseANumber{
    
    
    public static int reverseTheGivenNumber(int n){
        
        int revNum = 0;
        int lastDigit = 0;
        
        while(n > 0 ){
            
            lastDigit = n % 10;
            
            n = n/10;
            
            revNum = revNum * 10 + lastDigit;
            
        }
        
        return revNum;
    }
    
    
    public static void main(String[] args){
        
        int n = 10400;
        
        System.out.println("The reverse number is :"+reverseTheGivenNumber(n));
    }
    
}

//o/p :- 401
