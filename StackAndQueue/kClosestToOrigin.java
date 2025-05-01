//Closest to the origin
//youtube : https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=8
//TC = O(nlogk)
/*
Logic:-

Dist: sqrt((x1-x2)^2 + (y1-y2)^2) 
 simplify as x1^2+ y1^2 as x2,y2 = 0,0 ie, origin

*/

import java.io.*;
import java.util.*;

class Pair{
    public int dist;
    public int x;
    public int y;
    
    public Pair(int dist, int x, int y){
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
    
}
public class kClosestToOrigin{
    
    public static void getTheTopKPointsClosestToOrigin(int[][] arr, int k){
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.dist - a.dist);
        
        for(int i=0;i<arr.length;i++){
            maxHeap.add(new Pair(arr[i][0]*arr[i][0] + arr[i][1]* arr[i][1], arr[i][0],arr[i][1]));
            
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        System.out.println("The points close to origin are:");
        while(maxHeap.size() > 0){
            Pair p = maxHeap.poll();
            System.out.println(p.x+","+p.y);
        }
    }

  public static void main(String args[]){
      
      int[][] a = {{1,3}, {-2,2},{5,8},{0,1}};
      int k = 2;
      getTheTopKPointsClosestToOrigin(a,k);
  }
}
    
/*

The points close to origin are:
-2,2
0,1

*/
