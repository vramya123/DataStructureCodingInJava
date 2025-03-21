/*
 Count the number of Digits 
 TC :- Olog10(n) where n is the number of digits bcz we we are dividing the number by 10 each time
 */


import java.io.*;
import java.util.*;


public class CountDigitsInNumber{
    
    
    public static int findTheNumberOfDigitsInGivenNumber(int num){
        
        int noOfDigits = 0;
        
        while( num > 0 ){
            
            //Removes the last digit in the number, quotient is assigned to num
            num = num /10;
            
            noOfDigits++;
        }

       //another one liner approach is noOfDigits = (int) Math.log10(num)+1;
        
        return noOfDigits;
    }
    
    
    public static void main(String[] args){
        
        int num = 5678;
        
        int noOfDigits = findTheNumberOfDigitsInGivenNumber(num);
        
        System.out.println("the no of digits for "+ num +" is:"+noOfDigits);
    }
    
    
    
}

//o/p:- the no of digits for 5678 is:4

/* Recursiobn version
 static int countDigit(long n)
	{
		if (n/10 == 0)
			return 1;
		return 1 + countDigit(n / 10);
	}
*/
