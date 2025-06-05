
/*
N-Ary DFS encode and decode
===========================

Approach
--------
1. Global StringBuilder declaration to use in the encode fns
   Static String COMMA = ","
   Static String X ="X";

2. In serialize do folllowing:-
   if(root == null)
     return X;
	encode(root)
	//remove last comma
	sb.deleteCharAt(sb.length()-1)
	return sb.toString();

3. encode(TreeNode root)
   //Add root val
   sb.append(root.val)
   sb.append(X)
   //Add children vals
   List<TreeNode> children = root.children;
   if(children != null && children.size() > 0){
       for(TreeNode child: children)
	     encode(child);
   }
   //Add X after each level if no children 
   sb.append(X)
   sb.append(COMMA)
   
4. Static String[] arr;
   Static int index = 0;
   
5. In deserailize, do the following
    arr = s.split(COMMA);
	return decode(arr);

6. In decode , do the following

   // Get the root node
   String cur = arr[index++];

   if(cur.equals(X)) return null;
   
   //Children
   List<TreeNode> children = new ArrayList<>();
   while(index > arr.length){
      TreeNode child = decode();
      if( child != null)
	     children.add(child);
      else  
	     break;
   }
   TreeNode node = new TreeNode(Integer.parseInt(cur), children);
   return node;
   
  */ 
   
   
   

import java.util.*;
import java.io.*;

 class TreeNode{
    
    public int val;
    public List<TreeNode> children;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
     public TreeNode(int val, List<TreeNode> child){
        this.val = val;
        children = child;
    }
    
}

public class Solution{
    public static StringBuilder sb = new StringBuilder();
    public static String X ="X";
    public static String COMMA = ",";
    
    
    public static String serializeNAryTree(TreeNode root){
        
        if(root == null) return X;
        
        //encode children
        encode(root);
        
        //remove last comma at the end of string
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
        
    }
    
    public static void encode(TreeNode root){
        //Add current node in string
        sb.append(root.val);
        sb.append(COMMA);
        //Add children
        List<TreeNode> childs = root.children;
        if(childs != null && childs.size() > 0){
            for(TreeNode child:childs){
                encode(child);
            }
        }
        sb.append(X);
        sb.append(COMMA);
    }
    
    static String[] sArr;
    static int index = 0;
    
    
    public static TreeNode deserialize(String sb){
        sArr = sb.split(COMMA);
        return decode();
    }
    
    public static TreeNode decode(){
        
        //Check current node
        String  cur = sArr[index++];
        if( cur.equals(X)) return null;
        
        //Create Children
        List<TreeNode> children = new ArrayList<>();
        while(index < sArr.length){
            TreeNode child = decode();
            if(child != null){
                children.add(child);
            }else{
                break;
            }
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur), children);
        return root;
        
    }
    
    
    public static void main(String[] args){
        //     1
        // 3    2  4
      // 5 6 
      
      List<TreeNode> child = new ArrayList<>();
      TreeNode a = new TreeNode(5);
      TreeNode b = new TreeNode(6);
      child.add(a);
      child.add(b);
      TreeNode c = new TreeNode(3,child);
      TreeNode d = new TreeNode(2);
      TreeNode e = new TreeNode(4);
      List<TreeNode> child2 = new ArrayList<>();
      child2.add(c);
      child2.add(d);
      child2.add(e);
      TreeNode root = new TreeNode(1,child2);
      
      String serial = serializeNAryTree(root);
      
      System.out.println(serial);
      
      TreeNode roo = deserialize(serial);
      
      preTrav(roo);
      
    }
    
    public static void preTrav(TreeNode root){
        if(root == null){
            System.out.print("null");
            return;
        }else{
            System.out.print(root.val);
        }
        for(TreeNode child:root.children){
        preTrav(child); 
        }
    }
    
}


o/p:-
=====
1,3,5,X,6,X,X,2,X,4,X,X                                                                                                                                                                            
