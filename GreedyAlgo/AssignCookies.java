/*

Assign cookies

Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

 

Example 1:

Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.


youtube: https://www.youtube.com/watch?v=DIX2p7vb9co&list=PLgUwDviBIf0rF1w2Koyh78zafB0cz7tea

*/

import java.io.*;
import java.util.*;


public class AssignCookies{
    
    
    public static int assignCookiesToKids(int[] greed, int[] size){
        
        Arrays.sort(greed);
        Arrays.sort(size);
        
        int r = greed.length;
        int m = size.length;
        
        int i = 0;
        int j = 0;
        
        while( i < r && j < m){
            if(greed[i] <= size[j] ){
                i++;
            }
            j++;
        }
        
        return i;
        
    }
    
    public static void main(String[] args){
        
        int[] greed = {1,2,3};
        int[] size = {1,1};
        
        System.out.println("The maximum children who can be satifies is :"+assignCookiesToKids(greed,size));
    }
}

//o/p:- The maximum children who can be satifies is :1
