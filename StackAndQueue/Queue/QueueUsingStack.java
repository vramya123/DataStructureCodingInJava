//Queue implementataion using Stack

//Youtube : https://www.youtube.com/watch?v=3Et9MrMc02A&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=4


//We can use two stacks, with below rules 
//For push:
//Movements from S1 to S2 one at a time
//Put element in S1
//put elements from S2 to S1 one at a time
//For poll:
//return the top element using pop()
//TC :O(N) for push and O(1) for poll  SC: O(2N)

import java.io.*;
import java.util.*;


//Optimal solution with using just two Stacks but with O(1) for push and amortized O(1) for poll
 
 
class Stack{
     int[] arr;
     int top;
    
    public Stack(int n){
        arr = new int[n];
        top = -1;
    }
    
    public  void push(int val){
        if((top < arr.length-1)){
            arr[++top] = val;
        }else{
           System.out.println("Stack is full");
        }
    }
    
    public  int  pop(){
        if(!isEmpty()){
            return arr[top--];
        }else{
            System.out.println("Stack already empty");
            return -1;
        }
    }
    
    public  int size(){
        return top+1;
    }
    
    public  boolean isEmpty(){
        return top == -1;
    }
    
    public  void printStack(){
        if(!isEmpty()){
         for(int i=0;i<=top;i++){
            System.out.println(arr[i]);
         }
        }else{
            System.out.println("stack is empty");
        }
    }
    
}
    
    

public class QueueUsingStack{
    
      Stack s1;
      Stack s2;
    
    public QueueUsingStack(int n){
       s1 = new Stack(n);
       s2 = new Stack(n);
    }
    
    public  void push(int val){
       s1.push(val);
    }
    
    
    public  int poll(){
        if(s2.isEmpty() == false){
             return s2.pop();
        }else{
            while(s1.isEmpty() == false){
                 s2.push(s1.pop()); 
            }
             return s2.pop();
        } 
    }
    
    public  void print(){
        System.out.println("s1:");
        s1.printStack();
        System.out.println("s2:");
        s2.printStack();
        
    }
    
    
    public static void main(String[] args){
        
        QueueUsingStack q = new QueueUsingStack(5);
         q.push(3);
         q.push(5);
         q.push(6);
         q.push(1);
         q.push(5);
         System.out.println(q.poll());
         q.push(6);
         System.out.println(q.poll());
         q.push(7);
         
         
         
    }
    
    
            
      //o/p : 
      //3
      //5
}
