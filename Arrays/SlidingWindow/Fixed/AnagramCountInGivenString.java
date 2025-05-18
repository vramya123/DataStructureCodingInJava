/*
Count Occurences of Anagrams

Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.

Example 1:

Input: txt = "forxxorfxdofr", pat = "for"
Output: 3
Explanation: for, orf and ofr appears in the txt, hence answer is 3.
Example 2:

Input: txt = "aabaabaa", pat = "aaba"
Output: 4
Explanation: aaba is present 4 times in txt.

*  Anagram refers to a jumbled up version of the given string

eg: str = fox ( 3 characters)

anagrams are : fox,oxf,ofx,xof,xfo,fxo   (3! strings)


*  youtube: https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5QQ

*/

import java.io.*;
import java.util.*;


public class AnagramCountInGivenString{
    
    public static int countTheNoOfAnagramInTheGivenString(String str, String pattern){
        
        char[] charArrStr = str.toCharArray();
        char[] charArrPatter = pattern.toCharArray();
        int countOfUniqueChar = 0;
        int k = charArrPatter.length;
        int i =0;
        int j =0;
        int ans = 0;
        
        //Get count of characters of the pattern
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char character : charArrPatter){
            int count = 1;
            if(map.containsKey(character)){
                count += map.get(character);
            }
            map.put(character,count);
        }
        
        countOfUniqueChar = map.size();
        
        //traverse the string array 
        while( j < charArrStr.length){
            
            //decrement the char count by 1 as you found it
            if(map.containsKey(charArrStr[j])){
                map.put(charArrStr[j], map.get(charArrStr[j]) -1);
                if(map.get(charArrStr[j]) == 0){
                    countOfUniqueChar--;
                }
            }
            
            if(j-i+1 < k){
                j++;
            }else  if(j-i+1 ==k){
                
                //update the count of anagrams
                if(countOfUniqueChar == 0){
                    ans++;
                }
                
                if(map.containsKey(charArrStr[i])){
                     map.put(charArrStr[i], map.get(charArrStr[i]) +1);
                     if(map.get(charArrStr[i]) == 1){
                         countOfUniqueChar++; 
                     }
                }
                
                i++;
                j++;
            }
            
        }
        
        return ans;
        
    }
    
    public static void main(String[] args){
         String txt = "aabaabaa";
         String pat = "aaba";
         
         System.out.println("The count of anagrams is : "+ countTheNoOfAnagramInTheGivenString(txt,pat));
    }
}

//o/p :- The count of anagrams is : 4
