/* Print all subsequence using recursion.

Subsequence :- A contiguous or non-contiguous sequence which follows the order.
eg: {1,2,3}

sequence : {}, {1},{2},{3},{1,2},{1,3}

{3,2} is not a subsequence as it does not maintain order ie, 1 after 2 after 3 in the given array

youtube:- https://www.youtube.com/watch?v=AxNNVECce8c&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=6

TC : O(2^N) * O(N)[2^N is for take and not take of each index and within each recusrion call we are using for loop to print so its another ~ O(N)]

SC : O(N)
*/


import java.io.*;
import java.util.*;

public class PrintAllSubsequence{
    public static void printSubsequence(int i, List<Integer> sub,int[] a){
        if(i == a.length){
            if(sub.size() == 0){
                  System.out.println("{}");
                  return;
            }
            for(int num : sub){
                System.out.print(num);
            }
            System.out.println();
            return;
        }
        
        //take that index into subsequence
        sub.add(a[i]);
        printSubsequence(i+1,sub,a);
        
         //Not take that index into subsequence
        sub.remove(sub.size()-1);
        printSubsequence(i+1,sub,a);
        
        
    }
    
    public static void main(String[] args){
        int[] a = {1,2,3,4};
        printSubsequence(0,new ArrayList<>(),a);
    }
    
}
/* o/p:-

1234
123
124
12
134
13
14
1
234
23
24
2
34
3
4

*/
