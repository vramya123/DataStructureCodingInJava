/*


Problem statement
Mr. X is a professional robber planning to rob houses along a street. Each house has a certain amount of money hidden. All houses along this street are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

You are given an array/list of non-negative integers 'ARR' representing the amount of money of each house. Your task is to return the maximum amount of money Mr. X can rob tonight without alerting the police.

Note:
It is possible for Mr. X to rob the same amount of money by looting two different sets of houses. Just print the maximum possible robbed amount, irrespective of sets of houses robbed.
For example:
(i) Given the input array arr[] = {2, 3, 2} the output will be 3 because Mr X cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses. So, he’ll rob only house 2 (money = 3)

(ii) Given the input array arr[] = {1, 2, 3, 1} the output will be 4 because Mr X rob house 1 (money = 1) and then rob house 3 (money = 3).

(iii) Given the input array arr[] = {0} the output will be 0 because Mr. X has got nothing to rob.


TC:- O(N)   SC :- O(1)

*/



import java.io.*;
import java.util.*;


public class MaxValueNonAdjacentHouseRobbing{
    
    
      public static int maxSumNonAdjSubsequenceForAGivenArrayWithSpaceOptimization(List<Integer> a){
        
        int prev2 = 0;
        int prev = a.get(0);
        
        for(int i=1;i< a.size();i++){
            
            int take = a.get(i) + prev2;
            int noTake = 0 + prev;
            
            int curi = Math.max(take, noTake);
            
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
    
    
    public static int maxValueNonAdjacentHouseRobbingForGivenArray(List<Integer> num){
        int n = num.size();
        List<Integer> tmp1 = new ArrayList<>();
        List<Integer> tmp2 = new ArrayList<>();
        
        if(num.size() == 1){
            return num.get(0);
        }
        
        for(int i=0;i<n;i++){
            if(i != 0){
               tmp1.add(num.get(i));
            }
            if(i != n-1){
               tmp2.add(num.get(i));
            }
        }
        
        return Math.max(maxSumNonAdjSubsequenceForAGivenArrayWithSpaceOptimization(tmp1),maxSumNonAdjSubsequenceForAGivenArrayWithSpaceOptimization(tmp2));
        
        
    }
    
    
    public static void main(String[] args){
        List<Integer> num = Arrays.asList(1, 2, 3, 1);
        
        System.out.println("The max value of house robbery without looting subsequent house is "+maxSumNonAdjSubsequenceForAGivenArrayWithSpaceOptimization(num));
        
        //The max value of house robbery without looting subsequent house is 4
    }
}
