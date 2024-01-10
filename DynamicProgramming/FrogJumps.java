/*


There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.


Youtube:- https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5

*/

import java.io.*;
import java.util.*;

public class FrogJumps{
    
    
    public static int minimumEnergyJumpsByFrogUsingMemoization(int n, int[] dp, int[] a){
        
        //base case
        
        if(n == 0)
          return 0;
         
        if(dp[n] != -1)
          return dp[n];
          
        int left = minimumEnergyJumpsByFrogUsingMemoization(n-1,dp,a) + Math.abs(a[n]- a[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = minimumEnergyJumpsByFrogUsingMemoization(n-2,dp,a) + Math.abs(a[n]-a[n-2]);
        }
        
        dp[n] = Math.min(left,right);
        
        return dp[n];
        
        //TC: O(N) [as we have reused previously computed results from dp, we have a linear recursion tree hence TC is O(N)]
        //SC : O(N) + O(N)
    }
    
    
    public static int minimumEnergyJumpsByFrogUsingTabulation(int n, int[] dp, int[] a){
        
        //base case
        
        dp[0] = 0;
        
        for(int i=1;i<n;i++){
            int left = dp[i-1] + Math.abs(a[i]-a[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = dp[i-2] + Math.abs(a[i]-a[i-2]);
            }
            
            dp[i] = Math.min(left,right);
        }
        return dp[n-1];
        
        //TC : O (N)
        //SC : O(N)
    }
    
    public static int minimumEnergyJumpsByFrogUsingTabulationOptimizedSpace(int n,int[] a){
        
     /*
     
     0       1     2      3    4     5
     prev2  prev  curi
            prev2 prev   curi
                  prev2  prev  curi
     */
    
    int prev = 0;
    int prev2 = 0;
    for(int i=1;i<n;i++){
        int left = prev + Math.abs(a[i]-a[i-1]);
        int right = Integer.MAX_VALUE;
        if(i > 1) right = prev2 + Math.abs(a[i]-a[i-2]);
        int curi= Math.min(left,right);
        prev2 = prev;
        prev = curi;
    }
    
    return prev;
        
    
    }
    
    public static void main(String[] args){
        int n = 3;
        int[] a = {10,20,30,10};
        int[] dp = new int[a.length+1];
        Arrays.fill(dp,-1);
        System.out.println("The minimum energy jumps to reach n is:"+ minimumEnergyJumpsByFrogUsingMemoization(n,dp,a));
        
        //o/p:- The minimum energy jumps to reach n is:20
        
        System.out.println("The minimum energy jumps to reach n is:"+ minimumEnergyJumpsByFrogUsingTabulation(n,dp,a));
        //o/p:- The minimum energy jumps to reach n is:20
        
        System.out.println("The minimum energy jumps to reach n is:"+ minimumEnergyJumpsByFrogUsingTabulationOptimizedSpace(n,a));
        //o/p:- The minimum energy jumps to reach n is:20
    }
    
    
}

