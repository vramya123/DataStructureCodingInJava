/* Intersection point in the given two linked list 

https://www.youtube.com/watch?v=0DYoPz2Tpt4


You are given two Singly Linked Lists of integers, which may have an intersection point.

Your task is to return the first intersection node. If there is no intersection, return NULL.



Example:-
The Linked Lists, where a1, a2, c1, c2, c3 is the first linked list and b1, b2, b3, c1, c2, c3 is the second linked list, merging at node c1.



*/

import java.io.*;
import java.util.*;

class Node{
    
    public int val;
    public Node next;
    
    public Node(){}
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
    
    public void setVal(int val){
        this.val = val;
    }
    
    public void setnode(Node next){
        this.next = next;
    }
    
    public int getVal(){
        return val;
    }
    
    public Node getNext(){
        return next;
    }
}

public class IntersectionPointOfTwoLinkedList{
    
    //Tc = O(N1) + O (N2) 
    //Sc = O(N1)
    public static Node getTheIntersectionOfTwoLinkedListNaiveApproach(Node h1, Node h2){
        
        int i = 0;
        Map<Node,Integer> hm = new HashMap<>();
        
        Node t1 = new Node(); 
        t1 = h1;
        Node t2 = new Node();
        t2 = h2;
        
        //If either LL is null, return null as no intersection point
        if(h1 == null || h2 == null) return null;
        
        
        //Traverse the first LL till end and memorize it in a hashmap to compare with second one
        while(t1 != null){
            hm.put(t1,i++);
            t1 = t1.next;
        }
        
        
        //Traverse second LL and check if it exists in hashmap . If exists then that's intersection point, else no 
        //intersection point 
        
        while(t2 != null){
            
            if(hm.containsKey(t2))
                return t2;
            
            t2 = t2.next;
            
        }
        
        return null;
    }
    
    
    //Tc = O(N1 + N2) 
    //Sc = O(1)
    public static Node getTheIntersectionOfTwoLinkedListEfficientApproach(Node h1, Node h2){
         
        //If either LL is null, return null as no intersection point
        if(h1 == null || h2 == null) return null;
        
        
       Node t1 = new Node(); 
        t1 = h1;
        Node t2 = new Node();
        t2 = h2;
        
        while(t1 != t2){
            
            t1 = t1.next;
            t2 = t2.next;
            
            //If intersection point is reached return either or
            //If both LL reach null at same time, no intersection point, so return null 
            if(t1 == t2) return t1;
            
            //If end of either LL is reached
            if(t1 == null) t1 = h2;
            if(t2 == null) t2 = h1;
            
            
            
        }
        
        //if starting node is intersection point ie, we pass same LL to both h1 and h2
        return t1;
        
    }
    
    
    public static void main(String[] args){
        
        Node a = new Node(8,null);
        Node b = new Node(10,a);
        Node c = new Node(12,b);
        
        Node e = new Node(35,b);
        Node d = new Node(24,e);
        
        
        Node intersectionPoint = getTheIntersectionOfTwoLinkedListEfficientApproach(a,d);
        System.out.println("The intersection point between two LL is:"+ intersectionPoint.getVal());
        
      Node intersectionPoint2 = getTheIntersectionOfTwoLinkedListNaiveApproach(a,d);
         System.out.println("The intersection point between two LL is:"+ intersectionPoint2.getVal());
        
    }
}

/*

o/p:-
The intersection point between two LL is:8
The intersection point between two LL is:8
*/
