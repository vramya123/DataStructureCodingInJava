//Remove duplicates from the given SORTED array and return the unique elements replaced at the begining of the array
//IP :- { 2, 3,4,2,4, 5,6}

//Youtube : https://www.youtube.com/watch?v=37E9ckMDdTk&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB

//Bruteforce:- 

//Traverse through array and put in a Set as it contains only unique elements(Insert in array takes logN time, so total time here is o(NlogN)), then get elements
//from set and insert in array begining as we need to return elemnts in array with index(Takes o(N) time)

// Algo for bruteforce:-
//Set<Integer> set = new LinkedHashSet<>(); Maintains order of insertion
//for(int i=0;i<a.length;i++)
//  set.add(a[i])
//index =0;
//Iterator<Integer> i = set.iterator();
//while(i.hasNext())
//    a[index] = set.get(i.next());
//    index++;



import java.io.*;
import java.util.*;


public class RemoveDuplicatesInSortedArray{
    
    public static int removeDuplicatesInGivenArray(int[] a){
        
        //Using two pointer approach
        int i =0;
        for(int j = 1;j<a.length;j++){
            if(a[j] != a[i]){
                a[i+1] = a[j];
                i++;
            }
        }
        return i+1;
    
    }
    
  
    
    public static void main(String[] args){
        
        int[] a = {1,2,3,7,8,8,9,9};
        
      
        int c = removeDuplicatesInGivenArray(a);
        
        System.out.println("The unique elements are till index "+c+ " of the array. They are");
        
        for(int i =0;i<c;i++){
            System.out.print(a[i]);
        }
        
        
    }
    
}

/* o/p :-

The unique elements are till index 6 of the array. They are
123789
*/
