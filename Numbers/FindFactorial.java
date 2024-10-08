/*

Factional of a given number 

TC = O(n)

Auxillary space : O(n)

*/

public class FindFactorial{
    
    
    public static int findFactorialOfGivenNumber(int n){
        
        //Base case
        
        if( n == 0) return 1;
        
        return n * findFactorialOfGivenNumber(n-1);
    }
     
    /*  f(5)                         120
          5 * f(4)                 5 * 24 
            4 * f(3)              4 * 6
              3 * f(2)           3 * 2
                2 * f(1)        2 * 1
                  1 * f(0)   1* 1
                  
    */
    
    public static void main(String[] args){
        
        int n = 5;
        
        System.out.println("The factorial of "+ n + " is "+findFactorialOfGivenNumber(n));
    }
}

//o/p:- The factorial of 5 is 120
