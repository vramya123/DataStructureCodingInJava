//N meeting in one room problem
//Youtube :- https://www.youtube.com/watch?v=II6ziNnub1Q&list=PLgUwDviBIf0pmWCl2nepwGDO05a0-7EfJ

/*
There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Example 1:

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output: 
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
*/


import java.io.*;
import java.util.*;


class Meeting{

  public int start;
  public int end;
  public int pos;
  
  public Meeting(int start, int end, int pos){
    this.start = start;
	this.end = end;
	this.pos = pos;
  }

}

class MeetingComparator implements Comparator<Meeting>{

  public int compare(Meeting m1, Meeting m2){
  
  if(m1.end < m2.end)
    return -1;
  else if(m1.end > m2.end)
    return 1;
  else if(m1.pos < m2.pos)
    return -1;
	
  return 1;
  
 }
}
  
  
public class MaxMeetingPerRoom{

     public static void maxMeetingPerRoom(int[] start, int[] end, int n){
	  List<Meeting> meet = new ArrayList<>();
	  
	  //put in an array , the newly created meeting objects
	  for(int i=0;i<start.length;i++){
	    meet.add(new Meeting(start[i], end[i],i+1));
	  }
	  
	  //Sort based on end time
	  MeetingComparator mc = new MeetingComparator();
	  Collections.sort(meet,mc);
	  
	  //Traverse through end time and put in new arraylist of meeting index
	  List<Integer> meetingsList = new ArrayList<>();
	  int endLimit = meet.get(0).end;
	  meetingsList.add(meet.get(0).pos);
	  for(int i=1;i<meet.size();i++){
	    if(meet.get(i).start > endLimit){
		  meetingsList.add(meet.get(i).pos);
		  endLimit = meet.get(i).end;
		}
	  }
	  
	  //print the meeting arraylist to get sequence of meeting
	  for(int i=0;i<meetingsList.size();i++){
	    System.out.println(meetingsList.get(i));
	  }
	 
	 }
	 
	 
	 public static void main(String[] args){
	   
	   int[] start = {1,3,0,5,8,5};
           int[] end =  {2,4,6,7,9,9};
           int n =6;	   
		
            maxMeetingPerRoom(start,end,n);
		
		
	 }


}
