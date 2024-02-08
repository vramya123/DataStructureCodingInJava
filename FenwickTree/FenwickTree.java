/*


Fenwick Tree 

Update : O(log n)
Get : O(log n)


Youtube:- https://www.youtube.com/watch?v=9uaXG62Y8Uw&list=PLgUwDviBIf0rf5CQf_HFt35_cF04d8dHN

*/

import java.io.*;
import java.util.*;


public class FenwickTree{
    
    public static void  update(int i, int val, List<Integer> fen){
        
       while(i < fen.size()){
           fen.set(i,fen.get(i)+val);
           i = (i + (i & (-i)));
       }
        
    }
    
    
    public  static int sum(int i, List<Integer> fen){
        int sum =0;
        
       while( i > 0 ){
           sum += fen.get(i);
           i = ( i- (i& (-i)));
       }
        return sum;
    }
    
    public static int sumRange(int l, int r,List<Integer> fen){
        
        return sum(r,fen) - sum(l-1,fen);
    }
    
    public static void createFenwickTree(List<Integer> a,List<Integer> fen){
        
        for(int i=1;i<= a.size()-1;i++){
            update(i,a.get(i),fen);
        }
    }
    
    public static void main(String[] args){
        
        List<Integer> a = Arrays.asList(0,1,2,3,4,5);
        List<Integer> fen = new ArrayList<>(Collections.nCopies(a.size()+1,0));
        
        createFenwickTree(a,fen);
        
        
        System.out.println("Sum(2,5) is :"+sumRange(2,5,fen));
        
         System.out.println("Sum(0,4) is :"+sum(4,fen));
    }
    
}

//Sum(2,5) is :14
//Sum(0,4) is :10
