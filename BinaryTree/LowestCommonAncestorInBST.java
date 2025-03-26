Try AI directly in your favorite apps … Use Gemini to generate drafts and refine content, plus get Gemini Advanced with access to Google’s next-gen AI for ₹1,950.00 ₹0 for 1 month
LCAINBST.txt
// https://www.youtube.com/watch?v=cX_kPV_foZc
// Lowest Common Ancestor in Binary Search Tree 

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
        if(root == null )
          return root;
         Tree cur = root;
         if(p.val < cur.val && q.val < cur.val)
             return lowestCommonAncestor(root.left,p,q);
         if(p.val > cur.val && q.val > cur.val)
             return lowestCommonAncestor(root.right,p,q);
           return root;
         
    }
    
    //    6
    //   2  8
    //     7  9
    //   
    public static void main(String[] args){
        Tree t1 = new Tree(7);
        Tree t2 = new Tree(9);
        Tree t3 = new Tree(2);
        Tree t5 = new Tree(8,t1,t2);
        Tree t6 = new Tree(6,t3,t5);  
        Tree dia = lowestCommonAncestor(t6,t1,t2);
        
        System.out.println(dia.val);
        
    }
    
}
