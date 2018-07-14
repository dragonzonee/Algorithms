Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

//
class Solution {
    //3 5 9 //4 10 12
    // public List<Interval> merge(List<Interval> intervals) {
    //     // sort start&end
    //     int n = intervals.size();
    //     int[] starts = new int[n];
    //     int[] ends = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         starts[i] = intervals.get(i).start;
    //         ends[i] = intervals.get(i).end;
    //     }
    //     Arrays.sort(starts);
    //     Arrays.sort(ends);
    //     // loop through
    //     List<Interval> res = new ArrayList<Interval>();
    //     for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
    //         if (i == n - 1 || starts[i + 1] > ends[i]) {
    //             res.add(new Interval(starts[j], ends[i]));
    //             j = i + 1;
    //         }
    //     }
    //     return res;
    // }
    
    public List<Interval> merge(List<Interval> intervals){
        List<Interval> res = new ArrayList<>();
        if(intervals.size()==0) return res;
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for(int i=0;i<intervals.size();i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int startPointer = 0;
        for(int i=0; i<starts.length;i++){
            if(i == intervals.size()-1 || starts[i+1]>ends[i]){
                res.add(new Interval(starts[startPointer],ends[i]));
                startPointer=i+1;
            }
        }
        return res;
    }
}