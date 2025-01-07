/*

Check if the given number is Armstrong number 

n = 1634

1^4 + 6 ^4 + 3 ^4 + 4 ^4 
= 1634

The sum of raised to number of digits of each digit results in same number

An Armstrong number is a number that is the sum of its own digits each raised to the power of the number of digits. 
For example, take the number 1634. The sum of its digits each raised to the power of 4 is 1634.

*/

public class NumberIsArmstrong {
    
    public static boolean checkIfGivenNumberNumberIsArmstrong(int n){
        
        int tmp = n;
        int sum = 0;
        
        int noOfDigits = (int) Math.log10(n) + 1;
        
        System.out.println(noOfDigits);
        
        while(tmp !=0){
            
            //Get the last digit
            int ld = tmp % 10;
            
            sum += Math.pow(ld, noOfDigits); 
            
            //Get the remaining number
            tmp = tmp / 10;
        }
        
        return (sum == n);
    }
    
  public static void main(String args[]) {
   
    int x = 1634;
    
    System.out.println("The given number "+ x + " is Armstrong :"+ checkIfGivenNumberNumberIsArmstrong(x));
  }
}

/* o/p:-

4
The given number 1634 is Armstrong :true

*/
