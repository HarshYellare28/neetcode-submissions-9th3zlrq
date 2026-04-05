class Solution {
    public HashMap<Character, Integer> getCountMap(String s, Integer i, Integer j){
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        while(i<j){
            if(countMap.containsKey(s.charAt(i))){
                countMap.put(s.charAt(i), countMap.get(s.charAt(i))+1);
            } else {
                countMap.put(s.charAt(i), 1);
            }
            i++;
        }
        return countMap;
    }

    public boolean checkInclusion(String s1, String s2) {
        Integer i=0;
        Integer j=s1.length();
        HashMap<Character, Integer> countMap = getCountMap(s1, i, j);
        HashMap<Character, Integer> iterMap = getCountMap(s2, i, Math.min(j, s2.length()));
        while(j<s2.length()){
            if(countMap.equals(iterMap)){
                return true;
            }
            if(iterMap.get(s2.charAt(i)) == 1){
                iterMap.remove(s2.charAt(i));
            } else {
                iterMap.put(s2.charAt(i), iterMap.get(s2.charAt(i))-1);
            }
            i++;
            if(iterMap.containsKey(s2.charAt(j))) {
                iterMap.put(s2.charAt(j), iterMap.get(s2.charAt(j))+1);
            } else {
                iterMap.put(s2.charAt(j), 1);
            }
            j++;
        }
        return countMap.equals(iterMap);
    }
}
