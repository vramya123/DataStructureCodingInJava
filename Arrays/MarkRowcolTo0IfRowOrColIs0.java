/*

You are given a matrix 'MATRIX' of dimension 'N' x 'M'. 
Your task is to make all the elements of row 'i' and column 'j' equal to 0 if any element in the 
ith row or jth column of the matrix is 0.

Note:

1) The number of rows should be at least 1.

2) The number of columns should be at least 1.

3) For example, refer to the below matrix illustration: 

Constraints:
1 <= N <= 100
1 <= M <= 100
-10^9 <= MATRIX[i][j] <= 10^9

Where 'MATRIX[i][j]' denotes the matrix element.
Follow Up:

Can you solve it with the space complexity of O(1)?

Time limit: 1 sec


Sample Input 1:

2 3

2 4 3
1 0 0

Sample Output 1:

2 0 0 
0 0 0 

Sample Input 2:

1 1 

5

Sample Output 2:

5 


youtube:- https://www.youtube.com/watch?v=N0MgLvceX7M

*/

import java.io.*;
import java.util.*;


public class MarkRowcolTo0IfRowOrColIs0{
    
    //brute force with TC = O(n*m) * (n+m) + (n+m)
    public static int[][] givenTheMatrixMarkRowColToZero(int[][] mat){
     
     int n = mat.length;
     int m = mat[0].length;
     
     //traverse array to check if entry is 0
     for(int i=0;i<n;i++){
         for(int j = 0;j<m;j++){
             if(mat[i][j] == 0){
                //mark the row and col with 0 as -1
                markRow(i,mat);
                markCol(j,mat);
             }
         }
     }
     
     //traverse array to mark all -1 with 0
     for(int i=0;i<n;i++){
         for(int j = 0;j<m;j++){
             if(mat[i][j] == -1){
                 mat[i][j] = 0;
             }
         }
     }
     
     
      return mat;
     
    }
    
     //mark the row  with 0 as -1
    public static void markRow(int i, int[][] mat){
        
        for(int j =0;j< mat[0].length;j++){
            if(mat[i][j] == 1){
                mat[i][j] = -1;
            }
        }
    }
    
     //mark the col with 0 as -1
    public static void markCol(int j, int[][] mat){
        
        for(int i =0;i< mat.length;i++){
            if(mat[i][j] == 1){
                mat[i][j] = -1;
            }
        }
    }
    
    
    
    
     // TC = O(n*m) , SC = O(n) + O(m)
    public static int[][] givenTheMatrixMarkRowColToZeroEfficiently(int[][] mat){
     
     int n = mat.length;
     int m = mat[0].length;
     int[] row = new int[mat.length];
     int[] col = new int[mat[0].length];
     
     Arrays.fill(row,0);
      Arrays.fill(col,0);
     
     //traverse array to check if entry is 0
     for(int i=0;i<n;i++){
         for(int j = 0;j<m;j++){
             if(mat[i][j] == 0){
                //mark the row and col with 0 as -1
                row[i] = 1;
                col[j] = 1;
             }
         }
     }
     
     //traverse array to mark all  row and col with 1 as 0
     for(int i=0;i<n;i++){
         for(int j = 0;j<m;j++){
             if(row[i] == 1 || col[j] == 1){
                 mat[i][j] = 0;
             }
         }
     }
     
     return mat;
    }
    
    // TC = O(n*m) , SC = O(1)
    public static int[][] givenTheMatrixMarkRowColToZeroEfficientlyWithMinimalSapce(int[][] mat){
        
        int col0 = 0;
        
        for(int i=0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    //mark row array to 0
                    mat[i][0] = 0;
                    
                    //mark col array to 0
                    
                    if(j > 0){
                        mat[0][j] = 0;
                    }else{
                       col0 = 0;
                    }
                }
                
            }
        }
        
        //Traverse all elements in array except 1st row and 1st col
        for(int i=1; i<mat.length;i++){
            for(int j =1;j<mat[0].length;j++){
                if(mat[i][j] != 0){
                    if(mat[i][0] == 0 || mat[0][j] ==0){
                        mat[i][j] = 0;
                    }
                }
            }
        }
        
        
        //Traverse first row
        if(mat[0][0] == 0){
            for(int j =0;j<mat[0].length;j++){
                mat[0][j] = 0;
            }
        }
        
        //Traverse first col
        if(col0 ==0 ){
            for(int i=0;i<mat.length;i++){
             mat[i][0] = 0;   
            }
        }
        
        return mat;
        
    }
    
    
    public static void main(String[] args){
        
        int[][] a = { {1,2,0},
        {0,1,0},
        {1,1,1}};
        
        givenTheMatrixMarkRowColToZero(a);
        
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        
         System.out.println("===================");
        
         int[][] b = { {1,2,0},
        {2,1,0},
        {1,0,1}};
        
        givenTheMatrixMarkRowColToZeroEfficiently(b);
         for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
        
         System.out.println("===================");
         
          int[][] c = { {1,2,2},
        {2,1,3},
        {1,0,1}};
        
        givenTheMatrixMarkRowColToZeroEfficientlyWithMinimalSapce(c);
         for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
        
         System.out.println("===================");
    }
}

/*

020
000
010
===================
000
000
000
===================
002
003
000
===================
*/
