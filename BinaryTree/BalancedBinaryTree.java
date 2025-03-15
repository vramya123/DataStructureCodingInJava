//Balanced Binary Tree ie, left tree height - right tree height <=1
//We return height of tree if tree is balanced tree, else we return -1


//Youtube : https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16
//TC = O (n) where n is number of nodes

import java.io.*;
import java.util.*;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val, TreeNode l, TreeNode r){
        this.val = val;
        this.left = l;
        this.right = r;
    }
    
}

public class BalancedBinaryTree{
    
    public static int checkBalancedBinaryTree(TreeNode root){
        
        if(root == null)
          return 0;
          
        int l = checkBalancedBinaryTree(root.left);
         if(l == -1 ) return -1;
        int r = checkBalancedBinaryTree(root.right);
         if(r == -1 ) return -1;
        if(Math.abs(l-r) >1) return -1;
        
        return 1+ Math.max(l,r);
    }
    
    
    public static void main(String[] args){
        
        //  2
        //4   5
        //6 7 9
        //10
        
        TreeNode a = new TreeNode(10,null,null);
        TreeNode b = new TreeNode(6,a,null);
         TreeNode c = new TreeNode(7,null,null);
        TreeNode d = new TreeNode(4,b,c);
         TreeNode e =new  TreeNode(9,null,null);
        TreeNode f = new TreeNode(5,e,null);
         TreeNode g =new  TreeNode(2,d,f);
         
         int val = checkBalancedBinaryTree(g);
         
         System.out.println("The val is "+ val);
        
    }
    
    
}

//o/p:- 4( No of nodes making the height of tree ie, height of tree is 3 and nodes is 4)
