/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if(n == 0 || n == 1) return n;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0;i<n;i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int currCount = 0;
        int maxCount = 0;
        int i=0;
        int j=0;
        while(i<n){
            if(start[i] < end[j]){
                currCount++;
                i++;
            } else {
                currCount--;
                j++;
            }
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }
}

//[(0,40),(5,35),(15,20)] // requires 3
//[(0,40),(5,10),(15,20)] //requires 2
//[(0,40),(5,10),(15,20)] 