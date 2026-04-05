class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int i = 0;
        int maxIx = 0;
        while(i < n){
            if(i > maxIx) return false;
            maxIx = Math.max(maxIx, i+nums[i]);
            i++;
        }
        return true;
    }
}
