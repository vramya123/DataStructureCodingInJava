//Queue implementataion using Array

//Youtube : https://www.youtube.com/watch?v=M6GnoUDpqEE&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=2

import java.io.*;
import java.util.*;


public class Queue{
    
    static int[] a ;
    static int count;
    static int n;
    static int rear;
    static int front;
    
    public Queue(int n){
        a = new int[n];
        count = 0;
        this.n = n;
        rear = 0;
        front = 0;
    }
    
    public static void push(int val){
        
        if(count < n){
            a[rear%n] = val;
            rear++;
            count++;
        }else{
            System.out.println("The queue is full");
        }
        
    }
    
    
    public static int poll(){
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
    
    public static void printQueue(){
        
        for(int i=front;i<rear;i++){
            System.out.print(a[i%n]+" ");
        }
        
    }
    
    
    public static void main(String[] args){
        
        Queue q = new Queue(5);
         q.push(3);
         q.push(5);
         q.push(6);
         q.push(1);
         q.push(5);
         q.poll();
         q.push(6);
         q.poll();
         q.push(7);
         
         q.printQueue();
         
    }
    
      //o/p : 6 1 5 6 7  
}
