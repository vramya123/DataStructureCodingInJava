/*

Longest Substring With Without Repeating Characters

Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


youtube:- https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11

*/

import java.io.*;
import java.util.*;


public class LongestSubStringWithAllUniqueCharacters{

 public static int findTheLongestSubstringWithAllUniqueCharacters(String str){
        
        
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int i =0,j=0;
        int n = str.length();
        
        while( j < n){
            
            //create a map of all unique characters as we traverse
            int count = 1;
            if(map.containsKey(str.charAt(j))){
                count = map.get(str.charAt(j));
                count += 1;
            }
            map.put(str.charAt(j), count);
            
           if(map.size() == j-i+1){
                max = Math.max(j-i+1, max);
                j++;
            }else if(map.size() < j-i+1){
                
                while( i <=j && map.size() < k){
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
        
        String str = "abcabcbb";
        
        System.out.println("The longest subarray with "+k+" unique characters is :"+ findTheLongestSubstringWithAllUniqueCharacters(str));

      }
      
}
