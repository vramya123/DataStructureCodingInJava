// Largest Rectangular Area in a Histogram
/*

Youtube:- https://www.youtube.com/watch?v=J2X70jj_I1o&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=7

Question : https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-using-stack/

Given a histogram represented by an array arr[], where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Task is to find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars whose heights are given in an array.

Example: 

Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
Output: 100

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

public class LargestAreaInHistogram{
    
    
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
    
    public static void main(String[] args){
        int a[] = {60, 20, 50, 40, 10, 50, 60};
        
        System.out.println("The max area rectangle in given histogram is :"+ getLargestRectangleAreaInGivenHistogram(a));
        }
    
}

//The max area rectangle in given histogram is :100
