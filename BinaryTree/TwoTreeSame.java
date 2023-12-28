//Check if two binary Tree are identical
//return true, otherwise false


//Youtube : https://www.youtube.com/watch?v=BhuvF_-PWS0&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=19

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

public class TwoTreeSame{
    
    //using preorder traversal to compare two trees
    public static boolean checkIfTwoTreeAreSame(TreeNode root1, TreeNode root2){
        
        if(root1 == null || root2 == null)
          return (root1 == root2);
          
        return (root1.val == root2.val) && checkIfTwoTreeAreSame(root1.left, root2.left) && checkIfTwoTreeAreSame(root1.right, root2.right);
          
       
    }
    
    
    public static void main(String[] args){
        
        //  T1:-
        //  2
        //4   5
        // T2:-
        //  2
        //4
        //o/p = false
        
        TreeNode a = new TreeNode(4,null,null);
        TreeNode b = new TreeNode(5,null,null);
         TreeNode c = new TreeNode(2,a,b);
         
         
        TreeNode d = new TreeNode(4,null,null);
         TreeNode e =new  TreeNode(2,d,null);
         
         boolean val = checkIfTwoTreeAreSame(c,e);
         
         System.out.println("The two tree are same: "+ val);
        
    }
    
    
}
