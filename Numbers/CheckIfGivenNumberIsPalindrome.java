/*
Given an integer, write a function that returns true if the given number is palindrome, else false. For example, 12321 is palindrome, but 1451 is not palindrome. 

TC = O(N)

*/

public class CheckIfGivenNumberIsPalindrome {
    
    public static boolean checkIfGivenNumberIsPalindromeOrNot(int n){
        
        int tmp = n;
        int rev = 0;
        
        while(tmp !=0){
            
            //Get the last digit
            int ld = tmp % 10;
            
            //reverse number
            rev = rev * 10 + ld;
            
            //Get the remaining number
            tmp = tmp / 10;
        }
        
        return (rev == n);
    }
    
  public static void main(String args[]) {
    //int x=1023;
    int x = 2332;
    
    System.out.println("The given number "+ x + " is palindrome :"+ checkIfGivenNumberIsPalindromeOrNot(x));
  }
}

/* o/p:-

The given number 1023 is palindrome :false

The given number 2332 is palindrome :true

*/
