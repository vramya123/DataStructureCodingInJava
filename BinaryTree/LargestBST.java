/*

Find the largest BST in a given Tree

Youtube:- https://www.youtube.com/watch?v=X0oXMdtUDwo&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=54


TC:- O(N)   SC:- O(1)

*/


import java.io.*;
import java.util.*;


class TreeNode{
    
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val= val;
        this.left= left;
        this.right = right;
    }
}

class NodeValue{
    public int minVal;
    public int maxVal;
    public int maxSize;
    
    public NodeValue(int minVal, int maxVal, int maxSize){
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.maxSize = maxSize;
    }
}

public class LargestBST{
    
    
    public static NodeValue findTheLargestBSTSize(TreeNode root){
        
        
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        NodeValue left = findTheLargestBSTSize(root.left);
        NodeValue right  = findTheLargestBSTSize(root.right);
        
        //Is a BST
        if(left.maxVal < root.val && root.val < right.minVal){
            return new NodeValue(Math.min(root.val, left.minVal), Math.max(root.val, right.maxVal),
               left.maxSize+right.maxSize+1);
        }
        
        //Not a BST
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
        
    }
    
    public static void main(String[] args){
        
        /*             20
                  /         \
              15                40
          /       \           /      \
        14         18        30       60
          \       /   \              /
          17    16      19         50
        
        */
        
        TreeNode t = new TreeNode(17, null,null);
        TreeNode t1 = new TreeNode(16, null,null);
        TreeNode t2 = new TreeNode(19, null,null);
        TreeNode t3 = new TreeNode(50, null,null);
        
        TreeNode t21 = new TreeNode(14, null,t);
        TreeNode t12 = new TreeNode(18, t1,t2);
        TreeNode t22 = new TreeNode(30, null,null);
        TreeNode t23 = new TreeNode(60, t3,null);
        
        TreeNode t212 = new TreeNode(15, t21,t12);
        TreeNode t211 = new TreeNode(40, t22,t23);
        
        TreeNode t231 = new TreeNode(20, t212,t211);
        
        System.out.println("The largest BST subtree size is "+ findTheLargestBSTSize(t231).maxSize);
        
    }
}

//O/p:- The largest BST subtree size is 4
