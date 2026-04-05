class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for(int num: nums){
            st.add(num);
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int curr = 1;
            if(!st.contains(nums[i]-1) && !visited.contains(nums[i])){
                int next = nums[i] + 1;
                while(st.contains(next)){
                    curr++;
                    next++;
                }
                visited.add(nums[i]);
            }
            
            max = Math.max(max, curr);
        }
        return max;
    }
}
