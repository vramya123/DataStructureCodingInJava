// Largest Rectangular Area in a 2D binary array
/*

Youtube:- https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8

Question : Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
Example:

Input :   0 1 1 0
          1 1 1 1
          1 1 1 1
          1 1 0 0
          
o/p:- 

1 1 1 1
1 1 1 1
 (8)
TC = O(n)

*/


import java.io.*;
import java.util.*;

class Pair{
    public int index;
    public int val;
    
    public Pair(int index, int val){
        this.index = index;
        this.val = val;
    }
}

public class LargestRectangleAreaInBinaryArray{
    
    
    public static List<Integer> getNearestSmallestToRight(int[] a){
        
        int rangeElem = a.length;
        List<Integer> res = new ArrayList<>();
        Stack<Pair> s = new Stack<>();
        
        for(int i = a.length-1;i>=0;i--){
            if(s.size() == 0){
                res.add(0,rangeElem);
            }else if(s.size() > 0 && s.peek().val < a[i]){
                res.add(0,s.peek().index);
            }else if(s.size() > 0 && s.peek().val >= a[i]){
                while(s.size() > 0 && s.peek().val >= a[i]){
                    s.pop();
                }
                
                if(s.size() == 0){
                    res.add(0,rangeElem);
                }else{
                    res.add(0,s.peek().index);
                }
            }
            s.push(new Pair(i, a[i]));
        }
        
        return res;
    }
    
    
    public static List<Integer> getNearestSmallestToLeft(int[] a){
        
        int rangeElem = -1;
        List<Integer> res = new ArrayList<>();
        Stack<Pair> s = new Stack<>();
        
        for(int i = 0;i < a.length;i++){
            if(s.size() == 0){
                res.add(rangeElem);
            }else if(s.size() > 0 && s.peek().val < a[i]){
                res.add(s.peek().index);
            }else if(s.size() > 0 && s.peek().val >= a[i]){
                while(s.size() > 0 && s.peek().val >= a[i]){
                    s.pop();
                }
                
                if(s.size() == 0){
                    res.add(rangeElem);
                }else{
                    res.add(s.peek().index);
                }
            }
            s.push(new Pair(i, a[i]));
        }
       
        return res;
    }
    
    public static List<Integer> getAreaOfRectangles(int[] a, List<Integer> left, List<Integer> right){
        List<Integer> width = new ArrayList<>();
        List<Integer> area = new ArrayList<>();
        
        for(int i =0;i<a.length;i++){
            width.add(right.get(i) - left.get(i) -1);
        }
        
        for(int i=0;i<a.length;i++){
            area.add(a[i] * width.get(i));
        }
        
        return area;
    }
    
    public static int computeMaxInGivenArray(List<Integer> a){
        
        int large = a.get(0);
        
        for(int i=1;i<a.size();i++){
            if(a.get(i) > large){
                large = a.get(i);
            }
        }
        return large;
    }
    
    public static int getLargestRectangleAreaInGivenHistogram(int[] a){
        
        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> area = new ArrayList<>();
        
        
        right = getNearestSmallestToRight(a);
        //right.forEach(System.out::print);
        //System.out.println();
        left = getNearestSmallestToLeft(a);
        //left.forEach(System.out::print);
        // System.out.println();
        area = getAreaOfRectangles(a, left, right);
        //area.forEach(System.out::print);
        // System.out.println();
        int maxAreaRec = computeMaxInGivenArray(area);
        
        return maxAreaRec;
        
    }
    
    public static int getLargestRectangleInBinaryMatrix(int[][] a){
        
        int[] v = new int[a[0].length];
        int rectangleSize = 0;
        
        //Convert 2D to ID one row at the time
        
        for(int j =0;j<a[0].length;j++){
            v[j] = a[0][j];
        }
        
        rectangleSize = getLargestRectangleAreaInGivenHistogram(v);
        
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j] == 0){
                    v[j] = 0;
                }else if(a[i][j] ==1){
                    v[j] = v[j] + a[i][j];
                }
            }
            
            rectangleSize = Math.max(getLargestRectangleAreaInGivenHistogram(v),rectangleSize);
            
        }
        
        return rectangleSize;
        
    }
    
    public static void main(String[] args){
        int a[][] = {{0, 1, 1, 0,},
          {1, 1, 1, 1},
          {1, 1, 1, 1},
          {1, 1, 0, 0}};
        
        System.out.println("The max area rectangle in given binary matrix is :"+ getLargestRectangleInBinaryMatrix(a));
        }
    
}

//The max area rectangle in given binary matrix is :8
