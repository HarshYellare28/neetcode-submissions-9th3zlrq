class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
            for(int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            List<Integer>[] bucket = new List[nums.length + 1];
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new ArrayList<>();
            }
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                bucket[entry.getValue()].add(entry.getKey());
            }
            int[] res = new int[k];
            int j=0;
            int i=bucket.length-1;
            while(j<k && i>0){
                if(!bucket[i].isEmpty()){
                    for(int n: bucket[i]){
                        res[j++]=n;
                    }
                }
                i--;
                if(j == k){
                    return res;
                }
            }
            return res;
    }
}
