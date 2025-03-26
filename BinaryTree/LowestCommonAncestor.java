Try AI directly in your favorite apps … Use Gemini to generate drafts and refine content, plus get Gemini Advanced with access to Google’s next-gen AI for ₹1,950.00 ₹0 for 1 month
lowestCommonAncestorInBT.txt
// https://www.youtube.com/watch?v=_-QHfMDde90&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=28
// Lowest Common Ancestor in Binary Tree 

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
    
   
    public static Tree lowestCommonAncestor(Tree root, Tree p, Tree q){
        if(root == null || root == p || root == q)
          return root;
         
         Tree l = lowestCommonAncestor(root.left,p,q);
         Tree r = lowestCommonAncestor(root.right,p,q);
         
         if(l == null)
           return r;
          else if(r == null)
           return l;
         else
           return root;
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
        Tree dia = lowestCommonAncestor(t6,t1,t2);
        
        System.out.println(dia.val);
        
    }
    
}

o/p :-  3
