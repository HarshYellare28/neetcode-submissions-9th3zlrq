class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str: strs){
            res.append(String.valueOf(str.length())).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        int n = str.length();
        List<String> res = new ArrayList<>();
        while(i<n){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j+1, j+1+len));
            i = j + 1 + len;
        }
        return res;
    }
}
