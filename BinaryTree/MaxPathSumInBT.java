

/* Question:

Given a non-empty binary tree, find the maximum path sum. For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
*/

Time and Space Complexity:-
==========================
Time is o(N)
Space is O(H) - height of tree


Approach:-

Post order traversal
left+right+root
max(l+r+root , max)
max(l,r)+root

Solution:-

import java.io.*;
import java.util.*;


class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
}
public class Solution{
    public static int max = Integer.MIN_VALUE;
    
    public static int maxPathFromAnyNodeToAnyNode(TreeNode n){
        postOrderTraversal(n);
        return max;
    }
    
    public static int postOrderTraversal(TreeNode n){
        //Base case
        if(n == null) return 0;
        
        //Find left and right values
        
        int left = Math.max(0, postOrderTraversal(n.left));
        
        int right = Math.max(0, postOrderTraversal(n.right));
        
        //Compute max
        
        max = Math.max(max, left+right+n.val);
        
        return Math.max(left,right)+n.val;
        
    }
    
    public static void main(String[] args){
          //     5
        // 3    7  
      // 1 4   6  8
     //              
        
      TreeNode b = new TreeNode(6);
      
      TreeNode a1 = new TreeNode(8);
      
      TreeNode a = new TreeNode(7,b,a1);
       
      TreeNode d = new TreeNode(1);
      TreeNode e = new TreeNode(4);
      TreeNode c = new TreeNode(3,d,e);
    
      TreeNode root = new TreeNode(5,c,a);
      
      System.out.println(maxPathFromAnyNodeToAnyNode(root));
    }
    
}
