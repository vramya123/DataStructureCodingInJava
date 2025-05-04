/* Rotate a 2D array by 90 

youtube:- https://www.youtube.com/watch?v=Z0R2u6gd3GU


TC = 


*/

import java.io.*;
import java.util.*;

public class Rotate2DArray{
    
    
    public static void rotate2DArrayByTransposeAndReverse(int[][] a){
        
       /*
        1 2 9      
        7 3 4  
        4 5 6
        
          ||
          
        1 7 4      
        2 3 5  =>   diagonal is fixed, only other elements gets swapped
        9 4 6
        
        [0][1] => [1][0]
        [0][2] => [2][0]
        [1][2] => [2][1]
        
        i => 0 to n-2
         j => i+1 to n    
         
         Logic for the top half above the diagonal 
         
         Then we need to reverse each row to get the rotataion matrix
         
         4 7 1 
         5 3 2 
         6 4 9
        
        */
        
        int n = a.length;
        int m = a[0].length;
        
        //swap elements across diagonal
        for(int i=0;i<n-1;i++){
            for(int j =i+1;j<n;j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        
        //reverse each row
        
        for(int i =0;i<n;i++){
            reverse(a,i);
        }
        
        
        //print array
        
        Arrays.stream(a)
              .forEach(row -> {
                  Arrays.stream(row)
                        .forEach(element -> System.out.print(element + " "));
                  System.out.println();
              });
        
        
    }
    
    public static void reverse(int[][] a , int i){
        
        int low = 0;
        int high = a.length-1;
        
        while(low < high){
            int tmp = a[i][low];
            a[i][low] = a[i][high];
            a[i][high] = tmp;
            low++;
            high--;
        }
    }
    
    public static void main(String[] args){
        int[][] a = {{1,2,9},
        {7,3,4},
        {4,5,6}
    };
    
    rotate2DArrayByTransposeAndReverse(a);

    }
}

/*
4 7 1 
5 3 2 
6 4 9
*/
