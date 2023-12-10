//Check if an array is sorted

//Youtube : https://www.youtube.com/watch?v=37E9ckMDdTk&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB




import java.io.*;
import java.util.*;


public class CheckIfArrayIsSorted{
    
    public static boolean checkIfGivenArrayIsSorted(int[] a){
        
        int large = a[0];
        for(int j = 1;j<a.length;j++){
            if( a[j] < large){
                return false;
            }else if(a[j] >= large){
                large = a[j];
            }
        }
        return true;
    
    }
    
  
    
    public static void main(String[] args){
        
        int[] a = {1,2,3,7,8,7,9,9};
        
      
        boolean c = checkIfGivenArrayIsSorted(a);
        
        System.out.println("The given array is in ascending order and sorted:"+c);
        
     
    }
    
}

/* o/p :-

The given array is in ascending order and sorted:false

*/
