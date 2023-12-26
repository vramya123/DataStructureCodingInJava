//Find the number that appear once and other number twice
//Youtube :https://www.youtube.com/watch?v=bYWLJb3vCWY&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=3



import java.io.*;
import java.util.*;


public class NumberThatAppearsOnce{
    
    
    public static int findTheNumberThatAppearsOnce(int[] a){
        
        //better solution using map
        int ans = -1;
        Map<Long, Long> map = new LinkedHashMap<>();
        
        //put values in map
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                 int count = map.get(a[i]);
                 count++;
                 map.put(a[i],count);
            }else{
                 map.put(a[i],1);
            }
        }
        
        //Traverse the map
       for(Map.Entry<Long,Long> entry : map.entrySet()){
           if(entry.getValue() == 1){
               ans = entry.getkey();
           }
       }
       
       return ans;
    }
    
    
    
}
