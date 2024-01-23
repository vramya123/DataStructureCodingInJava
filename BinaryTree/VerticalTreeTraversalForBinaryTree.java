/*


Vertical traversal of the Tree 

Youtube :- https://www.youtube.com/watch?v=q_a6lpbKJdw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=22

TC: O(N)log(N)   Sc : O(N)

*/


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

class Tuple{
    
    public TreeNode node;
    public int row;
    public int col;
    
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
    
}

public class VerticalTreeTraversalForBinaryTree{
    
    
    public static List<List<Integer>>  verticalTraversalForTheGivenBinaryTree(TreeNode root){
        
        // x axis ->  y axis -> { values}
        /*        
          -2    -1    0     1     2
                     0,0
                -1,1       1,1
           -2,2      0,2          2,2
          
          
        */
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));
        
        while(!q.isEmpty()){
            
            Tuple t =  q.poll();
            int x = t.row;
            int y = t.col;
            TreeNode node = t.node;
            
            if(! map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            
            if(! map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            
            map.get(x).get(y).add(node.val);
            
            if(node.left != null){
                q.add(new Tuple(node.left,x-1,y+1));
            }
            
            if(node.right != null){
                q.add(new Tuple(node.right,x+1,y+1));
            }
            
        }
        
        
        //Put result in List of List
        List<List<Integer>> list = new ArrayList<>();
        
        for(Map<Integer,PriorityQueue<Integer>> vals : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : vals.values()){
                while(!nodes.isEmpty()){
                    //System.out.println(nodes.peek()); 
                    list.get(list.size()-1).add(nodes.poll());
                }
            } 
        }
        
        return list;
        
    }
    
    public static void main(String[] args){
        
          //  2
        // 4    5
        //6  7 9
      //10
        
        TreeNode a = new TreeNode(10,null,null);
        TreeNode b = new TreeNode(6,a,null);
         TreeNode c = new TreeNode(7,null,null);
        TreeNode d = new TreeNode(4,b,c);
         TreeNode e =new  TreeNode(9,null,null);
        TreeNode f = new TreeNode(5,e,null);
         TreeNode g =new  TreeNode(2,d,f);
         
         List<List<Integer>> list = verticalTraversalForTheGivenBinaryTree(g);
         
         for(List<Integer> l : list){
             System.out.println("Level :");
             System.out.println("===========");
             l.forEach(System.out::println);
         }
    }
    
    
}

/*

o/p:-

Level :
===========
10
Level :
===========
6
Level :
===========
4
Level :
===========
2
7
9
Level :
===========
5

*/
