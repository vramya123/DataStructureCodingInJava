/*

Flood Fill Problem

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Youtube:- https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9

TC:- O(X)+ O(X*4) ~ O(X)  where X is N*M ie, row * col
*/


import java.io.*;
import java.util.*;


public class FloodFillProblem{
    
    
    public static void dfs(int[][] image, int row, int col, int newColor,int[] delRow, int[] delCol, int[][] newImage , int iniColor){
        
        newImage[row][col] = newColor;
        for(int i=0;i<delRow.length;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if( nrow >=0  && nrow < image.length && ncol >=0 && ncol < image[0].length && newImage[nrow][ncol]!= newColor  && image[nrow][ncol] == iniColor){
                dfs(image,nrow,ncol,newColor,delRow,delCol,newImage,iniColor);
            }
        }
    }
    
    
    
    
    public static int[][]  floodFillTheGivenImage(int[][] image, int sr, int sc, int newColor){
        
        int[][] newImage = image;
        int row = image.length;
        int col = image[0].length;
         int iniColor = image[sr][sc];
         /*
        row-1,col-1      row-1,col     row-1,col+1        -1,-1    -1,0    -1,+1
        row,col-1        row,col       row,col+1           0,-1     0,0,     0,+1
        row+1,col-1      row+1,col     row+1,col+1         +1,-1   +1,0     +1,+1
         */
        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};
         
        dfs(image,sr,sc,newColor,delRow,delCol,newImage,iniColor);
         
        return newImage;
        
        
    }
    
    
    public static void main(String[] args){
        
        int image[][] = {{ 1,1,1},
                         {1,1,0},
                         { 1,0,1}};
        
        int[][] newImage = floodFillTheGivenImage(image,1,1,2);
        
        for(int i=0;i<newImage.length;i++){
            for(int j=0;j<newImage[0].length;j++){
                System.out.print(newImage[i][j]);
            }
            System.out.println("\n");
        }
    }
}

/* o/p:-
222

220

201

*/
