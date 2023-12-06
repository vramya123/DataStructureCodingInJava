// Boundary traversal of binary tree 
// Youtube : https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=21


import java.io.*;
import java.util.*;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
}

public class BoundaryTraversal{
    
    public static void  leftBoundaryTraversal(TreeNode root, List<Integer> res){
        TreeNode cur = root.left;
        while(cur !=null){
            if(!isLeaf(cur))
             res.add(cur.val);
            if(cur.left != null) cur = cur.left;
            else 
             cur = cur.right;
        }
    }
    
    public static void leafTraversal(TreeNode root, List<Integer> res){
        if(isLeaf(root)){
         res.add(root.val);
         return;
        }
        if(root.left != null)leafTraversal(root.left,res);
         if(root.right != null)leafTraversal(root.right,res);
    }
    
    public static void rightBoundaryTraversalFromBottomToUp(TreeNode root, List<Integer> res){
        List<Integer> tmp = new ArrayList<>();
        TreeNode cur = root.right;
        while(cur != null){
            if(!isLeaf(cur))
              tmp.add(cur.val);
            if(cur.right != null) cur = cur.right;
            else
             cur = cur.left;
        }
        
        for(int i = tmp.size()-1;i>=0;i--){
            res.add(tmp.get(i));
        }
    
    }
    
    public static boolean isLeaf(TreeNode root){
        return (root.left == null && root.right == null);
    }
    
    public static void main(String[] args){
         //  2
        // 4    5
        //6 7  9
        //10
        
        TreeNode a = new TreeNode(10,null,null);
        TreeNode b = new TreeNode(6,a,null);
         TreeNode c = new TreeNode(7,null,null);
        TreeNode d = new TreeNode(4,b,c);
         TreeNode e =new  TreeNode(9,null,null);
        TreeNode f = new TreeNode(5,e,null);
         TreeNode root =new  TreeNode(2,d,f);
         
         List<Integer> res = new ArrayList<>();
         if(!isLeaf(root))
           res.add(root.val);
         leftBoundaryTraversal(root,res);
         leafTraversal(root,res);
         rightBoundaryTraversalFromBottomToUp(root,res);
         
         res.forEach(System.out::println);
    }
    
}

/* op:- 2
4
6
10
7
9
5 */
