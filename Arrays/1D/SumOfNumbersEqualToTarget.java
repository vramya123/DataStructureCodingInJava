/*
Problem statement
Sam want to read exactly ‘TARGET’ number of pages.

He has an array ‘BOOK’ containing the number of pages for ‘N’ books.

Return YES/NO, if it is possible for him to read any 2 books and he can meet his ‘TARGET’ number of pages.

Example:
Input: ‘N’ = 5, ‘TARGET’ = 5
‘BOOK’ = [4, 1, 2, 3, 1] 

Output: YES
Explanation:
Sam can buy 4 pages book and 1 page book.


Youtube :- https://www.youtube.com/watch?v=UXDSeD9mN-k&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=5

*/


import java.io.*;
import java.util.*;


public class SumOfNumbersEqualToTarget{
    
    //Tc :- O(N2)  Sc:- O(1)
    public static int[] sumOfNumbersEqualToTargetBruteForce(int[] num,int target){
        
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                if(num[i] + num[j] == target){
                    int[] res = {i,j};
                    return res;
                }
            }
        }
        int[] res = {-1,-1};
        return  res;
    }
    
    // TC :- O(NlogN) ordered hashMap else it will O(N2)   Sc :- O(N)
    /*
    Time Complexity:
map : O ( l o g n ) O(log n) O(logn) for insertion, deletion, and finding.
unordered_map : Average O ( 1 ) O(1) O(1) for insertion, deletion, and finding. Worst case O ( n ) O(n) O(n) due to hash collisions.
    */
    public static int[] sumOfNumbersEqualToTargetBetterApproach(int[] num, int target){
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<num.length;i++){
            int num2 = target - num[i];
            if(map.containsKey(num2)){
                int[] res = {map.get(num2),i};
                return res;
            }
            map.put(num[i],i);
        }
         int[] res = {-1,-1};
        return  res;
    }
    
    public static String sumOfNumbersEqualToTargetUsingTwoPointerApproach(int[] num, int target){
        
        int low = 0;
        int high = num.length -1;
        
        Arrays.sort(num);
        
        while(low<=high){
            if(num[low]+ num[high] == target){
                return "yes";
            }else if(num[low] + num[high] < target){
                low++;
            }else{
                high--;
            }
        }
        
        return "no";
    }
    
    
    
    
    
    public static void main(String[] args){
        
        int[] num = {4, 1, 2, 3, 1};
        int target = 5;
        
        int[] res = sumOfNumbersEqualToTargetBruteForce(num,target);
        
        System.out.println("The sum of two numbers equal to target index is "+res[0]+","+res[1]);
        //The sum of two numbers equal to target index is 0,1
        
        res = sumOfNumbersEqualToTargetBetterApproach(num,target);
         
         System.out.println("The sum of two numbers equal to target index is "+res[0]+","+res[1]);
        //The sum of two numbers equal to target index is 0,1
        
         System.out.println("The sum of two numbers equal to target  is present "+sumOfNumbersEqualToTargetUsingTwoPointerApproach(num,target));
         //The sum of two numbers equal to target  is present yes
    }
}
