//Stack implementataion using Queue

//Youtube : https://www.youtube.com/watch?v=jDZQKzEtbYQ&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=3


//We can use two queues, with below rules 
//For push:
//Put element in Q2
//Movements from Q1 to Q2 one at a time
//put elements from Q2 to Q1 one at a time
//For pop:
//return the front element using poll()
//TC :O(N)  SC: O(2N)

import java.io.*;
import java.util.*;


//Optimal solution with using just one queue
 class Queue{
    
     int[] a ;
     int count;
     int n;
     int rear;
     int front;
    
    public Queue(int n){
        a = new int[n];
        count = 0;
        this.n = n;
        rear = 0;
        front = 0;
    }
    
    
    public  int size(){
        return count;
    }
    
    public  void push(int val){
        
        if(count < n){
            a[rear%n] = val;
            rear++;
            count++;
        }else{
            System.out.println("The queue is full");
        }
        
    }
    
    
    public  int poll(){
        int val = 0;
        if(count == 0){
            System.out.println("The queue is empty");
        }else{
            val = a[front % n];
            a[front % n] = -1;
            front++;
            count--;
        }
        return val;
    }
    
    public  void printQueue(){
        
        for(int i=front;i<rear;i++){
            System.out.print(a[i%n]+" ");
        }
        
    }
    
 }
    
    

public class StackUsingQueue{
    
    public static Queue q;
    
    public StackUsingQueue(int n){
       q = new Queue(n);
    }
    
    public static void push(int val){
        
       q.push(val);
       for(int i=0;i<q.size()-1;i++){
              q.push(q.poll());
       }
        
    }
    
    
    public static int pop(){
        return q.poll();
    }
    
    public static void print(){
        
        q.printQueue();
        
    }
    
    
    public static void main(String[] args){
        
        StackUsingQueue q = new StackUsingQueue(5);
         q.push(3);
         q.push(5);
         q.push(6);
         q.push(1);
         q.push(5);
         q.pop();
         q.push(6);
         q.pop();
         q.push(7);
         
         q.print();
         
    }
            
      //o/p : 7 1 6 5 3   
}
