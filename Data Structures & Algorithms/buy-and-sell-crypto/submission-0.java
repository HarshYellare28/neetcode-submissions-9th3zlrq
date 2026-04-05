class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxAtRight = new int[n];
        maxAtRight[n-1] = prices[n-1]; 
        int maxm = maxAtRight[n-1];
        for(int i=n-2;i>=0;i--){
            maxAtRight[i] = prices[i] > maxAtRight[i+1] ? prices[i] : maxAtRight[i+1];
        }
        int res = 0;
        for(int i=0;i<n-1;i++){
            int curr = maxAtRight[i+1] - prices[i];
            res = curr > res ? curr : res;
        }
        return res;
    }
}