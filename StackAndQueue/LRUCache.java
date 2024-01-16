/*

Least recently used cache implementation using stack and doubly linked list


youtube :- https://www.youtube.com/watch?v=Xc4sICC8m4M&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=10

get at O(1)  and put O(1)

*/


import java.io.*;
import java.util.*;

class Node{
    public int key;
    public int val;
    public Node prev;
    public Node next;
    
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
    
    
}
public class LRUCache{
    
    Node head;
    Node tail;
    Map<Integer,Node> map;
    int capacity;
    
    public LRUCache(int n){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        map = new HashMap<>();
        capacity = n;
    }
    
    //Put 
    public void put(int key, int val){
        if(map.containsKey(key)){
           remove(map.get(key));
         }
         if(map.size() == capacity){
            remove(tail.prev); 
         }
         insert(new Node(key,val));
    }
    
    //Get
    public  int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            insert(n);
            return n.val;
        }else
          return -1;
    }
    
    
    //Insert next to head
    //head ->  n -> headNext...tail
    //     <-   <-
    public  void insert(Node n){
        map.put(n.key,n);
        Node headNext = head.next;
        head.next = n;
        n.prev = head;
        n.next = headNext;
        headNext.prev = n;
    }
    
    //Remove prev to tail
    //head ->  ....n -> tail
    //     <-        <-
    public  void remove(Node n){
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    public static void main(String[] args){
       LRUCache lRUCache = new LRUCache(2);
       lRUCache.put(1, 1); // cache is {1=1}
       lRUCache.put(2, 2); // cache is {1=1, 2=2}
       System.out.println(lRUCache.get(1));    // return 1
       lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
       System.out.println(lRUCache.get(2));    // returns -1 (not found)
       lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
       System.out.println(lRUCache.get(1));    // return -1 (not found)
       System.out.println(lRUCache.get(3));    // return 3
       System.out.println(lRUCache.get(4));    // return 4
       
       
    }
    
}

/*
output:-

1
-1
-1
3
4
*/
