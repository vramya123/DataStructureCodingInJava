//Union of two sorted array

//Youtube :- https://www.youtube.com/watch?v=wvcQg43_V8U&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=6

//Brute force For union: Use Set to store value after traversing each array and then traverse the set and put in a new arraylist and return. Time complexity will be o(2nlogn)+o(n)

//Brute Force For intersection : Traverse whole second array for each element of first array . If there is match, check the visisted array of second array to see if its taken. If not taken add in result list. 
import java.io.*;
import java.util.*;



public class UnionIntersectionOfTwoSortedArray{
    
    //Use two pointer approach
    public static List<Integer> unionOfTwoSortedArray(int[] a,int[] b){
        int n1 = a.length;
        int n2 = b.length;
        int i=0;
        int j=0;
        List<Integer> union = new ArrayList<>();
        
        while( i < n1 && j < n2){
            if(a[i] <= b[j]){
                if(union.size() == 0 || union.get(union.size()-1) != a[i])
                    union.add(a[i]);
                i++;
            }else{
                if(union.size() == 0 || union.get(union.size()-1) != b[j])
                   union.add(b[j]);
                j++;
            }
        }
        
        while(i < n1){
            if(union.get(union.size()-1) != a[i])
               union.add(a[i]);
            i++;
        }
        
        while( j < n2){
            if(union.get(union.size()-1) != b[j])
                union.add(b[j]);
            j++;
        }
        return union;
        //TC :  O(n+m)
        //SC : O(n+m)
    }
    
    public static List<Integer> intersectionOfTwoSortedArray(int[] a, int [] b){
        int n1 = a.length;
        int n2 = b.length;
        int i=0;
        int j=0;
        List<Integer> inter = new ArrayList<>();
        
        while( i < n1 && j < n2){
            if( a[i] < b[j]){
                i++;
            }else if(a[i] > b[j]){
                j++;
            }else{
                inter.add(a[i]);
                i++;
                j++;
            }
        }
        return inter;
        //TC :  O(n+m)
        //SC : O(n+m)
    }
    
    
    public static void main(String[] args){
        
        int[] a = { 2,3,3,4,5,6,7};
        int[] b = { 3,4,5,6,6,6};
        
        System.out.println("The Union is :");
        List<Integer> c = unionOfTwoSortedArray(a,b);
        c.forEach((val) ->{
            System.out.print(val + " ");
        });
        
        System.out.println("\nThe Intersection is :");
        
        List<Integer> c2 = intersectionOfTwoSortedArray(a,b);
        c2.forEach((val) ->{
            System.out.print(val + " ");
        });
        
    }
    
    
    
}

/*
The Union is :
2 3 4 5 6 7 
The Intersection is :
3 4 5 6
*/
