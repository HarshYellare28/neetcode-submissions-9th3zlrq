class Solution {
    public boolean checkCanEat(int[] piles, int k, int h){
        int turns = 0;
        for(int i=0; i < piles.length; i++){
            int val = piles[i]/k;
            int rem = piles[i]%k;
            if(val > 0) {
                if(rem != 0){
                    turns += (val + 1);
                } else {
                    turns += val;
                }
            } else{
                turns += 1;
            }
        }
        return turns <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int ans = right; // Initialize with max possible value
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(checkCanEat(piles, mid, h)){
                ans = mid;
                right = mid - 1; // Try to find a smaller valid speed
            } else {
                left = mid + 1; // Need to eat faster
            }
        }
        return ans;
    }
}
