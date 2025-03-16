Try AI directly in your favorite apps … Use Gemini to generate drafts and refine content, plus get Gemini Advanced with access to Google’s next-gen AI for ₹1,950.00 ₹0 for 1 month
DiameterofbTree.txt
// https://www.youtube.com/watch?v=Rezetez59Nk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=17
//Diameter of a BT

import java.io.*;
import java.util.*;


class Tree{
    public int val;
    public Tree left;
    public Tree right;
    
    public Tree(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    
    public Tree(int val, Tree left, Tree right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution{
    
    //Logic : max(lhs+rhs) at every node , 1+max(l,r)
    
    public static int diameterForBT(Tree root){
       int[] diameter = new int[1];
       maxDepthForBT(root,diameter);
       return diameter[0];
    }
    
    public static int maxDepthForBT(Tree root, int[] diameter){
        if(root == null)
          return 0;
         
         int l = maxDepthForBT(root.left,diameter);
         int r = maxDepthForBT(root.right,diameter);
         
         diameter[0] = Math.max(diameter[0],l+r);
         
         return 1+ Math.max(1,r);
    }
    
    //    1
    //   2  3
    //     4  6
    //   5
    public static void main(String[] args){
        Tree t1 = new Tree(5);
        Tree t2 = new Tree(6);
        Tree t3 = new Tree(2);
        Tree t4 = new Tree(4,t1,null);
        Tree t5 = new Tree(3,t4,t2);
        Tree t6 = new Tree(1,t3,t5);  
        int dia = diameterForBT(t6);
        
        System.out.println(dia);
        
    }
    
}

o/p:- 5 ( no of nodes in the diameter ie, 2,1,3,4,5)
