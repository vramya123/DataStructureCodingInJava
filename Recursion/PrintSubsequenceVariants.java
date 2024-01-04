/*

Print all subsequences for the given array matching the given value

Print one subsequence for the given array matching the given value

Print the count of  subsequence  for the given array matching the given value

Youtube :- https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7


TC : O(2^n)   SC : O(N)
*/

import java.io.*;
import java.util.*;

public class PrintSubsequenceVariants{
    
    public static void printSubsequenceMatchingTheSum(int i,  List<Integer> list, int tmpSum, int[] a,int sum){
        
        //base case
        
        if(i >= a.length){
            if(tmpSum == sum){
                for(int j : list){
                    System.out.print(j+ " ");
                }
                System.out.println();
            }
            return;
        }
        
        //Take index
        tmpSum += a[i];
        list.add(a[i]);
        printSubsequenceMatchingTheSum(i+1,list,tmpSum,a,sum);
        
        //Don't take index
        tmpSum-= a[i];
        list.remove(list.size()-1);
        printSubsequenceMatchingTheSum(i+1,list,tmpSum,a,sum);
        
    
    /*
         a = [1, 2, 1]
              0  1  2
              
                                     Recursion Tree for the given input array 
    
    
                                                   f(0,[],2)
                       f(1,[ 1],2)                                                f(1,[],2)
      f(2,[1,2],2)                     f(2,[1],2)                 f(2,[2],2)                     f(2,[],2)
f(3,[1,2,1],2)  f(3,[1,2],2)     f(3,[1,1],2)  f(3,[1],2)  f(3,[2,1],2)   f(3,[2],2)       f(3,[1],2)  f(3,[],2)
                                  (ans)                                     (ans)
    

    
    */
    }
    
    public static boolean printOneSubsequenceMatchingTheSum(int i,  List<Integer> list, int tmpSum, int[] a,int sum){
        
        //Base Case
        if( i >= a.length){
            if(tmpSum == sum){
                for(int j : list){
                    System.out.print(j+ " ");
                }
                System.out.println();
                return true;
            }else{
              return false;
           }         
        }
        
        //Take
        tmpSum+= a[i];
        list.add(a[i]);
        if(printOneSubsequenceMatchingTheSum(i+1,list,tmpSum,a,sum) == true){
            return true;
        }
        
        //Don't take
        tmpSum-= a[i];
        list.remove(list.size()-1);
        if(printOneSubsequenceMatchingTheSum(i+1,list,tmpSum,a,sum) == true){
            return true;
        }
        
        return false;
    }
    
    
     public static int printCountOfSubsequenceMatchingTheSum(int i, int tmpSum, int[] a,int sum){
         
         //Base Case
         
         if( i >= a.length){
             if(tmpSum == sum){
                 return 1;
             }else{
                 return 0;
             }
         }
         
         //Take
         tmpSum += a[i];
         int l = printCountOfSubsequenceMatchingTheSum(i+1,tmpSum,a,sum);
         
         //Don't Take
         tmpSum-= a[i];
         int r = printCountOfSubsequenceMatchingTheSum(i+1,tmpSum,a,sum);
         
         return l+r;
         
         
         
     }
    
    public static void main(String[] args){
        
        int[] a = {1,2,1};
        int sum = 2;
        printSubsequenceMatchingTheSum(0,new ArrayList<>(),0,a,sum);
        /*
        o/p:- 
        1 1 
        2 
        */
        printOneSubsequenceMatchingTheSum(0,new ArrayList<>(),0,a,sum);
        /* o/p:-
        1 1 
        */
        
        System.out.println("The total subsequence matching sum "+ sum +" is :"+ printCountOfSubsequenceMatchingTheSum(0,0,a,sum));
        /*
        o/p:-
        The total subsequence matching sum 2 is :2
        */
    }
}



