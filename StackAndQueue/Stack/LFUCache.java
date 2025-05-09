/*


LFU Cache

Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
 
 Youtube:- https://www.youtube.com/watch?v=mzqHlAW7jeE&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=10
 
 
 TC:- O(1) get and O(1) put
 
 */
 
 import java.io.*;
 import java.util.*;
 
 
 class DLLNode{
     public int key;
     public int val;
     public int freq;
     public DLLNode next;
     public DLLNode prev;
     
     public DLLNode(int key, int val){
         this.key = key;
         this.val = val;
         this.freq = 1;
         next = null;
         prev = null;
     }
     
 }
 
 
 class DoublyLinkedList{
     public int size;
     public DLLNode head;
     public DLLNode tail;
     
     public DoublyLinkedList(){
         this.size = 0;
         head = new DLLNode(0,0);
         tail = new DLLNode(0,0);
         head.next = tail;
         tail.prev = head;
     }
     
     public void insertNode(DLLNode node){
         DLLNode headNext = head.next;
         head.next = node;
         node.prev = head;
         node.next = headNext;
         headNext.prev = node;
         size++;
     }
     
     
     public void deleteNode(DLLNode node){
         DLLNode prevNode = node.prev;
         DLLNode nextNode = node.next;
         prevNode.next = nextNode;
         nextNode.prev = prevNode;
         size--;
     }
     
 }
 
 
 public class LFUCache{
     
     public int capacity;
     public int currentCapacity;
     public int minFreq;
     public Map<Integer,DLLNode> cache;
     public Map<Integer,DoublyLinkedList> freqMap;
     
     
     public LFUCache(int size){
         this.capacity = size;
         this.currentCapacity = 0;
         this.minFreq = 1;
         cache = new HashMap<>();
         freqMap = new HashMap();
     }
     
     
     public int get(int key){
        DLLNode node = cache.get(key);
        
        if(node == null){
            return -1;
        }
        
        updateNode(node);
         printCache();
        printDLL();
        return node.val;
     }
     
     public void put(int key, int val){
         
         if(capacity == 0){
           return;
         }
         
         if(cache.containsKey(key)){
            DLLNode dlnode = cache.get(key);
            dlnode.val = val;
            updateNode(dlnode);
         }else{
             currentCapacity++;
             if(currentCapacity > capacity){
                 DoublyLinkedList dll = freqMap.get(minFreq);
                 cache.remove(dll.tail.prev.key);
                 dll.deleteNode(dll.tail.prev);
                 currentCapacity--;
                 
             }
             
             minFreq=1;
             
             DLLNode dnode = new DLLNode(key,val);
             DoublyLinkedList dl = freqMap.getOrDefault(1,new DoublyLinkedList());
             dl.insertNode(dnode);
             cache.put(key,dnode);
             freqMap.put(minFreq,dl);
         }
         printCache();
        printDLL();
     }
     
     
     public void updateNode(DLLNode node){
         int curFreq = node.freq;
         DoublyLinkedList dl = freqMap.get(curFreq);
         dl.deleteNode(node);
         
         if(curFreq == minFreq && dl.size == 0){
             minFreq++;
         }
         
         node.freq++;
         
         DoublyLinkedList newdl = freqMap.getOrDefault(node.freq,new DoublyLinkedList());
         newdl.insertNode(node);
         freqMap.put(node.freq,newdl);
     }
     
     public  void printCache(){
         System.out.println("=========Cache  Hash Map=============");
         for(Map.Entry<Integer,DLLNode> entry : cache.entrySet()){
             
             System.out.println("key:"+entry.getKey()+" Value:"+entry.getValue().val);
         }
     }
     
     public  void printDLL(){
         System.out.println("=======Freq Hash Map and Linked List ==========");
         for(Map.Entry<Integer,DoublyLinkedList> entry: freqMap.entrySet()){
             
             System.out.println("Key:"+entry.getKey());
             DoublyLinkedList dll = entry.getValue();
             DLLNode tmp = dll.head.next;
             while(tmp.next !=null){
                 System.out.print(" Value:"+tmp.val);
                 tmp = tmp.next;
             }
             System.out.println();
         }
     }
     
     
     public static void main(String[] args){
         
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
       
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
     }
     
 }
 
 /*
 output:-
 
 =========Cache  Hash Map=============
key:1 Value:1
=======Freq Hash Map and Linked List ==========
Key:1
 Value:1
=========Cache  Hash Map=============
key:1 Value:1
key:2 Value:2
=======Freq Hash Map and Linked List ==========
Key:1
 Value:2 Value:1
=========Cache  Hash Map=============
key:1 Value:1
key:2 Value:2
=======Freq Hash Map and Linked List ==========
Key:1
 Value:2
Key:2
 Value:1
=========Cache  Hash Map=============
key:1 Value:1
key:3 Value:3
=======Freq Hash Map and Linked List ==========
Key:1
 Value:3
Key:2
 Value:1
=========Cache  Hash Map=============
key:1 Value:1
key:3 Value:3
=======Freq Hash Map and Linked List ==========
Key:1

Key:2
 Value:3 Value:1
=========Cache  Hash Map=============
key:3 Value:3
key:4 Value:4
=======Freq Hash Map and Linked List ==========
Key:1
 Value:4
Key:2
 Value:3
=========Cache  Hash Map=============
key:3 Value:3
key:4 Value:4
=======Freq Hash Map and Linked List ==========
Key:1
 Value:4
Key:2

Key:3
 Value:3
=========Cache  Hash Map=============
key:3 Value:3
key:4 Value:4
=======Freq Hash Map and Linked List ==========
Key:1

Key:2
 Value:4
Key:3
 Value:3

*/
