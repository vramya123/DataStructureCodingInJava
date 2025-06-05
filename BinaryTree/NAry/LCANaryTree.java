/*
Lowest common ancestor for n-ary tree
*/
import java.io.*;
import java.util.*;

class TreeNode{
    
    public int val;
    public List<TreeNode> children;
    
    public TreeNode(int val){
        this.val = val;
        this.children = null;
    }
    
    public TreeNode(int val, List<TreeNode> children){
        this.val = val;
        this.children = children;
    }
}


class LCAHelper{
    
    
    public TreeNode findLCAForGivenNAryTree(TreeNode root, Set<TreeNode> nodes){
        int count = 0;
        TreeNode tmp = null;
        
        if(root == null){
            return root;
        }
        
        if(nodes.contains(root)){
            return root;
        }
        
        List<TreeNode> childs = root.children;
        if(childs != null && childs.size() > 0){
            for(TreeNode child : childs){
                TreeNode res =findLCAForGivenNAryTree(child, nodes);
                if(res != null){
                    count++;
                    if(count == 1){
                        tmp = res;
                     }
                }
            }
        }
        
        return count > 1 ? root:tmp;
    }
}



public class MyClass {
  public static void main(String args[]) {
         //   1
        // 3    2  4
      // 5 6 7
     // 8
      
      List<TreeNode> child = new ArrayList<>();
      TreeNode c2 = new TreeNode(8);
      TreeNode a = new TreeNode(5,Arrays.asList(c2));
      TreeNode b = new TreeNode(6);
      TreeNode b2 = new TreeNode(7); 
      child.add(a);
      child.add(b);  
      child.add(b2);
     
      TreeNode c = new TreeNode(3,child);
      TreeNode d = new TreeNode(2);  
      TreeNode e = new TreeNode(4);
      List<TreeNode> child2 = new ArrayList<>();
      child2.add(c);
      child2.add(d);
      child2.add(e);
      
      TreeNode root = new TreeNode(1,child2);
      
      Set<TreeNode> nodesToFind = new LinkedHashSet<>();
      nodesToFind.add(b2);
      nodesToFind.add(c2);
        
        
      LCAHelper obj = new LCAHelper();
      
      TreeNode parent = obj.findLCAForGivenNAryTree(root,nodesToFind);
     
      System.out.println(parent.val);
    

  }
}

//o/p:- 3
