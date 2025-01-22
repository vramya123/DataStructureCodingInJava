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
    }
}

/*
i/p:-
1 2 0
0 1 0
1 1 1

o/p:-
020
000
010

