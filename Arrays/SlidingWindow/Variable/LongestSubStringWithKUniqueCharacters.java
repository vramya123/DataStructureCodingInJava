/*

Longest Substring with K Uniques

Given a string s, you need to print the size of the longest possible substring with 
exactly k unique characters. If no possible substring exists, print -1.

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: "cbebebe" is the longest substring with 3 distinct characters.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: "aabaaab" is the longest substring with 2 distinct characters.


youtube: https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11

Patteren:-

while(j < n){
    
    //calculation
    
    if( constraint < k){
        j++
    }else if ( constraint == k){
        
        //ans
        j++
    }else if(constraint > k){
        
        while( constraint > k){
            update constraint 
            i++
        }
    }
}

*/


import java.io.*;
import java.util.*;


public class LongestSubStringWithKUniqueCharacters{
    
    
    public static int findTheLongestSubstringWithKUniqueCharacters(String str, int k){
        
        
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int i =0,j=0;
        int n = str.length();
        
        while( j < n){
            
            //create a map of unique characters as we traverse
            int count = 1;
            if(map.containsKey(str.charAt(j))){
                count = map.get(str.charAt(j));
                count += 1;
            }
            map.put(str.charAt(j), count);
            
            if( map.size() < k){
                j++;
            }else if(map.size() == k){
                max = Math.max(j-i+1, max);
                j++;
            }else if(map.size() > k){
                
                while( i <=j && map.size() > k){
                        int val  = map.getOrDefault(str.charAt(i),0);
                        map.put(str.charAt(i), val -1);
                        if(map.get(str.charAt(i)) == 0){
                            map.remove(str.charAt(i));
                        }
                        i++;
                }
                j++;
            }
        }
        
        return max;
        
    }
    
      public static void main(String[] args){
        
        String str = "aabacbebebe";
        
        int k = 3;
        
        System.out.println("The longest subarray with "+k+" unique characters is :"+ findTheLongestSubstringWithKUniqueCharacters(str,k));

      }
      
}

//o/p:- The longest subarray with 3 unique characters is :7
