/*
Given a list of intervals, remove all intervals that are covered by another interval in the list.

Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals.

 

Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
Example 2:

Input: intervals = [[1,4],[2,3]]
Output: 1
Example 3:

Input: intervals = [[0,10],[5,12]]
Output: 2
Example 4:

Input: intervals = [[3,10],[4,10],[5,11]]
Output: 2
Example 5:

Input: intervals = [[1,2],[1,4],[3,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= intervals[i][0] < intervals[i][1] <= 10^5
All the intervals are unique.
   Hide Hint #1  
How to check if an interval is covered by another?
   Hide Hint #2  
Compare each interval to all others and check if it is covered by any interval.
*/

// Explanation :- https://youtu.be/FAVqqeLy5Xk 

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        if(intervals!= null && intervals.length < 2) {
            return intervals.length;
        }
        
        /* Arrays.sort(intervals,
                   new Comparator<int[]>() { 
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[0] > entry2[0]) 
                return 1; 
            else
                return -1; 
          } 
        });
        
        
        */
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
    
        int start = 0;
        int end = 1;
        int count =  0;
        
        // [[1,4],[2,8],[3,6]]
        
        while(start<intervals.length && end<intervals.length) {
            if(start==end) {
                end++;
                continue;
            }
            if(intervals[start][0]<=intervals[end][0] && intervals[start][1]>=intervals[end][1]) {
                count++;
                end++;
                continue;
            } else if(intervals[start][0]<=intervals[end][0]) {
                
                                         start++;}
            else if(intervals[start][1]>=intervals[end][1]) {
                    
                     end++;
                    
            }
            
        }
                                                                                                 
        return intervals.length-count;
        
    }
}
