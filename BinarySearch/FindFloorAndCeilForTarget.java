/*

You're given a sorted array 'a' of 'n' integers and an integer 'x'.Find the floor and ceiling of 'x' in 'a[0..n-1]'.



Note:
Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'. num <= x
Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'. num >= x


Example:
Input: 
n=6, x=5, a=[3, 4, 7, 8, 8, 10]   

Output:
4

Explanation:
The floor and ceiling of 'x' = 5 are 4 and 7, respectively.


Youtube :- https://www.youtube.com/watch?v=6zhGS79oQ4k&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=3


*/


import java.io.*;
import java.util.*;


public class FindFloorAndCeilForTarget{
    
    
    //Finding floor ie, largest num <= x ie, num <= x
    //Finding ceil ie, smallest number >= x ie, num >= x
    public static int findCeilForTargetInGivenArray(int[] a, int target){
        
        int low = 0;
        int high = a.length-1;
        int ans = a.length;
        
        
        //find ceil
        while(low <= high){
            
            int mid = low + (high-low)/2;
            
            if(a[mid] >= target){
                ans = a[mid];
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        
        return ans;
    }
        
    public static int findFloorForTargetInGivenArray(int[] a, int target){
        
        int low = 0;
        int high = a.length-1;
        int ans = a.length;
        
        //find floor
        while(low <= high){
            int mid = low+ (high-low)/2;
            
            if(a[mid] <= target){
                ans = a[mid];
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        
        return ans;
    }
    
    
    
    public static int[] findFloorAndCeilForTargetInGivenArray(int[] a, int target){
        int floor = findFloorForTargetInGivenArray(a,target);
        int ceil = findCeilForTargetInGivenArray(a,target);
        return new int[] {ceil,floor};
    }
    
    
    public static void main(String[] args){
        
        int[] a = { 2, 3, 5, 7, 9, 10,10};
        int target = 8;
        
        int[] res = findFloorAndCeilForTargetInGivenArray(a,target);
        
        System.out.println("The ceil and floor for target is :"+ res[0] + "," + res[1]);
        //The ceil and floor for target is :7,7 [for target = 11]
        
         //The ceil and floor for target is :9,7 [for target = 8]
    }
}
