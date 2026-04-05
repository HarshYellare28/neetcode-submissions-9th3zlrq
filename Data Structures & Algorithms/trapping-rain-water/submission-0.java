class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int sum = 0;
        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                sum += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                sum += rightMax - height[right];
            }
        }
        return sum;
    }
}