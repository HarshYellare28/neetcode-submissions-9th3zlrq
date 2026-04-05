class Solution {
    public int maxArea(int[] height) {
        int currSum = 0;
        int maxSum = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right){
            if(height[left] < height[right]){
                currSum = height[left]*(right-left);
                left++;
            } else {
                currSum = height[right]*(right-left);
                right--;
            }
            maxSum = currSum < maxSum ? maxSum : currSum;
        }
        return maxSum;
    }
}