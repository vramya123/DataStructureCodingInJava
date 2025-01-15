/*


Hashing 

Time complexity
================

Ordered Map : Best case, worst case and average case TC is O(log n)

Unordered Map : Best case, average case TC is O(1) and worst case is O(n)


Implementation
===============





*/


import java.io.*;
import java.util.*;


public class StringHashing{
    
    //Logic if all character in given string are lower case
    public static int checkCharacterOccurranceInGivenString(String s, char key){
        
        //hash array
        int[] hash = new int[26];
        Arrays.fill(hash,0);
        
        //creation of hash array
        for(char ch : s.toCharArray()){
            hash[ch - 'a']++;
        }
        
        return hash[key-'a'];
    }
    
     //Logic if all character in given string are either lower case or upper case
    public static int checkCharacterOccurranceInGivenStringSplCase(String s, char key){
        
        //hash array
        int[] hash = new int[256];
        Arrays.fill(hash,0);
        
        //creation of hash array
        for(char ch : s.toCharArray()){
            hash[ch]++;
        }
        
        return hash[key];
    }
    
    
    public static void main(String[] args){
        
        String s = "samuell";
        char key = 'l';
        
        System.out.println("The occurrence of letter "+ key +" is :" +checkCharacterOccurranceInGivenString(s,key));
        
        s = " SaHRRUreLL";
        key = 'r';
        System.out.println("The occurrence of letter "+ key +" is :" +checkCharacterOccurranceInGivenStringSplCase(s,key));
    }
    
}

/* o/p:-

The occurrence of letter l is :2
The occurrence of letter r is :1
*/
