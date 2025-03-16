
https://www.youtube.com/watch?v=lqAcyVz1Hz8

BST
===

1) LEVEL ORDER TRAVERSAL

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
    public TreeNode(int val, TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution{
    
     public static List<List<Integer>> levelTraversal(TreeNode root){
         
         List<List<Integer>> res = new ArrayList<>();
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         
         while(! q.isEmpty()){
             int size = q.size();
             
             List<Integer> sub = new ArrayList<>();
             for(int i=0;i<size;i++){
                 TreeNode first = q.poll();
                 sub.add(first.val);
                 
                 if(first.left != null){
                     q.add(first.left);
                 }
                 
                 if(first.right != null){
                     q.add(first.right);
                 }
             }
             res.add(sub);
         }
         return res;
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
      
      
      List<List<Integer>> res = levelTraversal(root);
      
      res.forEach((l) ->{
          System.out.println(l.toString());
      });
     }
}
    
   

2) ZIG ZAG LEVEL ORDER TRAVERSAL

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
    public TreeNode(int val, TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution{
    
     public static List<List<Integer>> levelTraversal(TreeNode root){
         
         List<List<Integer>> res = new ArrayList<>();
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         boolean leftToRight = true;
         while(! q.isEmpty()){
             int size = q.size();
             
             List<Integer> sub = new ArrayList<>();
             for(int i=0;i<size;i++){
                 TreeNode first = q.poll();
                 if(leftToRight){
                 sub.add(first.val);
                 }else{
                     sub.add(0,first.val);
                 }
                 
                 if(first.left != null){
                     q.add(first.left);
                 }
                 
                 if(first.right != null){
                     q.add(first.right);
                 }
             }
             leftToRight = !leftToRight;
             res.add(sub);
         }
         return res;
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
      
      
      List<List<Integer>> res = levelTraversal(root);
      
      res.forEach((l) ->{
          System.out.println(l.toString());
      });
     }
}
    
   
3)  AVG of SUM At EACh LEVEL

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
    public TreeNode(int val, TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution{
    
     public static List<Double> levelTraversal(TreeNode root){
         
         List<Double> res = new ArrayList<>();
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         
         while(! q.isEmpty()){
             int size = q.size();
             Double sum = 0.0;
             for(int i=0;i<size;i++){
                 TreeNode first = q.poll();
                 
                 if(first.left != null){
                     q.add(first.left);
                 }
                 
                 if(first.right != null){
                     q.add(first.right);
                 }
                 
                 sum += first.val;
                 
             }
             Double avg = sum/size;
             res.add(avg);
         }
         return res;
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
      
      
      List<Double> res = levelTraversal(root);
      
      //res.forEach(System.out::println);
      
      System.out.println(res.toString());
     }
}
    
   
4)  Next Pointer point to right node

import java.util.*;
import java.io.*;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution{
    
     public static TreeNode levelTraversal(TreeNode root){
         
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         
         while(! q.isEmpty()){
             int size = q.size();
             TreeNode prev = null;
             for(int i=0;i< size;i++){
                 TreeNode first = q.poll();
                 if(prev !=null){
                     prev.next = first;
                 }
                 prev = first;
                 
                 if(first.left != null){
                     q.add(first.left);
                 }
                 
                 if(first.right != null){
                     q.add(first.right);
                 }
             }
         }
        return root;
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
      
      
      TreeNode res = levelTraversal(root);
      
      trav(res);
     
     }
     
     
     public static void trav(TreeNode root){
          
          if(root == null) return;
          System.out.println(root.val);
          trav(root.left);
          trav(root.right);
          
          
      
     }
}
    
   


5)  BST without left or right

https://www.youtube.com/watch?v=BcQXUsd-f1k

import java.util.*;
import java.io.*;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution{
    
     public static TreeNode levelHorizontalNullForNonPerfevtBST(TreeNode root){
         
        TreeNode head = root;
        
        while(head !=null){
             TreeNode dummy = new TreeNode();
             TreeNode temp = dummy;
             
             while(head !=null){
                 
                 if(head.left != null){
                     temp.next = head.left;
                     temp = temp.next;
                 }
                 
                 if(head.right != null){
                     temp.next = head.right;
                     temp = temp.next;
                 }
                 
                 head = head.next;
             }
             head = dummy.next;
            
        }
        
        return root;
     
     }
        

    
    
    public static void main(String[] args){
        //     5
        // 3    7  
      // 1 4   6  8
      

      TreeNode b = new TreeNode(6);
      TreeNode a1 = new TreeNode(8);
      
      TreeNode a = new TreeNode(7,null,a1);
       
      TreeNode d = new TreeNode(1);
      TreeNode e = new TreeNode(4);
      TreeNode c = new TreeNode(3,d,e);
    
      TreeNode root = new TreeNode(5,c,a);
      
      
      TreeNode res = levelHorizontalNullForNonPerfevtBST(root);
      
      trav(res);
     
     }
     
     
     public static void trav(TreeNode root){
          
          if(root == null) return;
          System.out.print(root.val);
          trav(root.left);
          trav(root.right);
          
          
      
     }
}
    
   
 
