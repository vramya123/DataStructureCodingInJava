/*

Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?

You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

For Example
If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.

Eg:-

10 40 70
20 50 80
30 60 90


Sample Output 1:
210

On the first day, Ninja will learn new moves and earn 70 merit points. 
On the second day, Ninja will do fighting and earn 50 merit points. 
On the third day, Ninja will learn new moves and earn 90 merit points. 
The total merit point is 210 which is the maximum. 
Hence, the answer is 210.


Youtube:- https://www.youtube.com/watch?v=AE39gJYuRog&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=10

*/


import java.io.*;
import java.util.*;


public class NinjaMaxPointRoutine{
    
    //Tc :- O(N*M)*(M+1)  SC:- O(N) + O(N*M)
    public static int findTheMaxiPointsOfNinjaRoutineUsingDPMemoization(int day, int last,int[][] points, int[][] dp){
        
        if(dp[day][last] != -1) return dp[day][last];
        
        if(day == 0){
            int max = 0;
            for(int task = 0; task < points.length;task++){
                if ( task != last){
                    max = Math.max(points[0][task],max);
                }
            }
            return dp[day][last] = max;
        }
        
        
        
        int max = 0;
        for(int task =0 ;task < points[0].length;task++){
            if(task != last){
                
                int point = points[day][task] + findTheMaxiPointsOfNinjaRoutineUsingDPMemoization(day-1,task,points,dp);
                
                max = Math.max(max,point);
            }
        }
        
        return dp[day][last] = max;
    }
    
    //TC : O(N*M)*(M+1)   SC: O(N*M)
    public static int findTheMaxiPointsOfNinjaRoutineUsingDPTabulation(int[][] points){
        
        int col = points[0].length;
        int row = points.length;
        int[][] dp = new int[row][col+1];
        
       dp[0][0] = Math.max(points[0][1],points[0][2]);
       dp[0][1] = Math.max(points[0][0],points[0][2]);
       dp[0][2] = Math.max(points[0][0],points[0][1]);
       dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
       
       for(int day = 1;day<dp.length;day++){
           for(int last = 0;last < dp[0].length;last++){
               
               dp[day][last] = 0;
               
             for(int task = 0;task <  points[0].length;task++){
                 if(task != last){
                    dp[day][last] = Math.max(dp[day][last],points[day][task]+dp[day-1][task]);
                 }
             }
           }
       }
       
       return dp[points.length-1][points[0].length];
    }
    
    public static int ninjaRoutine(int[][] points){
        
        int col = points[0].length;
        int row = points.length;
        int[][] dp = new int[row][col+1];
        
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        
        return findTheMaxiPointsOfNinjaRoutineUsingDPMemoization(row-1, col,points,dp);
    }
    
    
    public static void main(String[] args){
        
        int[][] points = {{10, 40, 70},
                          {20, 50, 80},
                          {30, 60, 90}};
                          
        
        System.out.println("The max point ninja routine using memoization is :" +  ninjaRoutine(points));
        
        
        System.out.println("The max point ninja routine using tabulation is :" +  findTheMaxiPointsOfNinjaRoutineUsingDPTabulation(points));

    }
	/*
	
	Recursion tree
	                                              (210)
	                                            f(2,3)
	                           (150)              (180)                  (210)
							30+f(1,0)          60+f(1,1)               90+f(1,2)
						(120)	(120)         (90)      (120)         (90)      (120)
					50+f(0,1)  80+f(0,2)   20+f(0,0)  80+f(0,2)    20+f(0,0)  50+f(0,1)
					     70        40         70          40         70	           70
						

  dp = 
           70   70	40
           120  120 120
           		        
           		        210
						 
						 */
						 
						 
	/*
	
	O/P:-
	The max point ninja routine using memoization is :210
    The max point ninja routine using tabulation is :210
*/
}
