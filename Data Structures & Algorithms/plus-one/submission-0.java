class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n-1;
        int[] res = new int[n+1];
        for(int j=0;j<n+1;j++){
            res[j]=0;
        }
        int startIndex = -1;
        while(i>=0){
            int currVal = digits[i] + 1;
            if(currVal < 10){
                res[i+1] = currVal;
                startIndex = i;
                break;
            }
            i--;
        }
        if(startIndex == -1){
            res[0] = 1;
            return res;
        }
        while(startIndex > 0){
            res[startIndex] = digits[startIndex-1];
            startIndex--;
        }
        int[] finalArr = new int[n];
        for(int j=1;j<n+1;j++){
            finalArr[j-1] = res[j];
        }
        return finalArr;
    }
}
