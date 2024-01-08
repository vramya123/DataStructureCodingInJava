/*
Next greater element in the array

Youtube:- https://www.youtube.com/watch?v=Du881K7Jtk8&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=6

TC : O(2N) + O(2n) ~ O(N)
SC : O(N)

*/

import java.io.*;
import java.util.*;


public class NextGreaterElement{
    
    public static int[] getTheNextGreaterElementForGivenArray(int[] arr){
        
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        
        //Traverse the circular array so its 2n
        for(int i=2*n-1;i >= 0;i--){
            
            //Remove all elements less than arr[i] if stack is not empty
            while(!s.empty() && s.peek() <= arr[i%n]){
                s.pop();
            }
            
            //we need to generate nge only from i to n-1 
            if(i < n){
                if(!s.empty()){
                    nge[i] = s.peek();
                }else{
                    nge[i] = -1;
                }
            }
            
            //put the lement in stack
            s.push(arr[i%n]);
            
        }
        
        return nge;
        
    }
    
    
    public static void main(String[] args){
        
        int[] arr = { 1,2,1,6,10,23,4,5,6};
        
        int[] nge = getTheNextGreaterElementForGivenArray(arr);
        
        for(int i=0;i<nge.length;i++){
            System.out.print(nge[i]+ " ");
        }
    }
    
    
    
}

/*

i/p:-  1,2,1,6,10,23,4,5,6
o/p:- 2 6 6 10 23 -1 5 6 10 


*/
