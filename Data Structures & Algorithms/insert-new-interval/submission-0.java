class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            int[][] res = new int[1][2];
            res[0][0] = newInterval[0];
            res[0][1] = newInterval[1];
            return res;
        }
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();
        //Case1: No overlap before merging
        while(i<n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        int newStartValue;
        if(i<n){
            newStartValue = Math.min(intervals[i][0], newInterval[0]);
        } else {
            newStartValue = newInterval[0];
        }  
        
        //Case2: Overlap found
        while(i<n && intervals[i][0] <= newInterval[1]){
            i++;
        }
        int newEndValue;
        if(i!=0){
            newEndValue = Math.max(intervals[i-1][1], newInterval[1]);
        } else {
            newEndValue = newInterval[1];
        }
        res.add(new int[]{newStartValue, newEndValue});
        
        //Case3 no overlap after merging
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        int j=0;
        int[][] arrRes = new int[res.size()][2];
        while(j<res.size()){
            arrRes[j] = res.get(j);
            j++;
        }
        return arrRes;
    }
}
