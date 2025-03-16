https://www.youtube.com/watch?v=F6kgir_v6AU&t=2s

o(log n)

Approach
=========
1) deleteBSt(root,int key)
2) if(root == null) return null;
3) if(root.val == key){
      //no kids
	  if(root.left == null && root.right == null)
	    return null;
	  // left kid
	  if( root.left != null && root.right == null)
	     return root.left;
	  // right kid
	  if(root.right !=null && root.left == null)
	   return root.right;
	  //both kids
	  TreeNode node = helper(root.right,root);
	  root.val = node.val;
}else if( root.val > key)
  root.left = deleteBST(root.left,key)
else if(key > root.val)
  root.right = deleteBST(root.right, key)

return root;

4) helper(root, parent){
   TreeNode prev = parent;
   TreeNode cur = root;
   while(cur.left != null){
      prev = cur;
	  cur = cur.left;
   }
   
   deleteBST(prev,cur.val);
   
   return cur;

}






Delete node in BST
==================


import java.util.*;
import java.io.*;

 class TreeNode{
    
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
     public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
}

public class Solution{
    
    public static TreeNode deleteBST(TreeNode root, int key){
        
        //base case
        
        if(root == null) return null;
        
        //delete root node cases
        if(root.val == key){
            //root has no children
            if(root.left == null && root.right == null){
             return null;
            }
            if(root.left == null && root.right != null){
            //has only one child
            return root.right;
            }
            if(root.right == null && root.left != null){
            //has only one child
            return root.left;
            }
            
            //has two children
            TreeNode node = helper(root.right, root);
            root.val = node.val;
            
        }else if(key > root.val){
            root.right = deleteBST(root.right,key);
        }else if(key < root.val){
            root.left = deleteBST(root.left,key);
        }
        
        return root;
    }
    
    public static TreeNode helper(TreeNode root, TreeNode parent){
        TreeNode prev = parent;
        TreeNode cur = root;
        
        while(cur.left != null){
            prev = cur;
            cur = cur.left;
        }
        
        deleteBST(prev, cur.val);
        return cur;
    }
    
    
    public static void main(String[] args){
        //     5
        // 3    7  
      // 1 4   6  8
      
      
      TreeNode b = new TreeNode(6);
      TreeNode a1 = new TreeNode(8);
      
      TreeNode a = new TreeNode(7,b,a1);
       
      TreeNode d = new TreeNode(1);
      TreeNode e = new TreeNode(4);
      TreeNode c = new TreeNode(3,d,e);
    
      TreeNode root = new TreeNode(5,c,a);
      
      
       TreeNode p1 = deleteBST(root,7);
       
       preTrav(p1);
      
      
    }
    
   public static void preTrav(TreeNode root){
        if(root == null){
           // System.out.print("null");
            return;
        }else{
            System.out.print(root.val);
        }
        preTrav(root.left);
        preTrav(root.right);
        }
    }
    
