//Stack Implementation using Array

// Youtube : https://www.youtube.com/watch?v=GYptUgnIM_I&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj


public class StackUsingArray{
    static int[] arr;
    static int top;
    
    public StackUsingArray(int n){
        arr = new int[n];
        top = -1;
    }
    
    public static void push(int val){
        if((top == arr.length-1)){
            System.out.println("Stack is full");
            
        }else{
            arr[++top] = val;
        }
    }
    
    public static void pop(){
        if(! isEmpty()){
        top = top-1;
        }else{
            System.out.println("Stack already empty");
        }
    }
    
    public static int top(){
         if(!isEmpty()){
            return arr[top];
         }else{
            System.out.println("stack is empty");
            return -1;
        }
    }
    
    public static int size(){
        return top+1;
    }
    
    public static boolean isEmpty(){
        return top == -1;
    }
    
    public static void printStack(){
        if(!isEmpty()){
         for(int i=0;i<=top;i++){
            System.out.println(arr[i]);
         }
        }else{
            System.out.println("stack is empty");
        }
    }
    
    
    public static void main(String[] args){
        
        StackUsingArray st = new StackUsingArray(4);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(6);
        st.push(2);
        st.pop();
        st.pop();
        st.printStack();
        
    }
}
/*
Stack is full
2
3
*/
