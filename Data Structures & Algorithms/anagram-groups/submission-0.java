class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<Pair<Map<Character, Integer>, String>> space = new List<>();
        // for(int i = 0; i<strs.length; i++){
        //     Map<Character, Integer> charCount = new HashMap<>();
        //     for(j=0;j<strs[i].size();j++){
        //         Character c = strs[i].charAt(j);
        //         if(charCount.containsKey(c)){
        //             charCount.put(c, charCount.get(c) + 1);
        //         } else {
        //             charCount.put(c, 1);
        //         }
        //     }
        //     space.add(new Pair<>(charCount, strs[i]));
        // }
        if(strs.length == 0) return Collections.emptyList();
        List<List<String>> space = new ArrayList<>();
        for(int i = 0; i<strs.length; i++){
            // Map<Character, Integer> charCount = new HashMap<>();
            char[] char_arr = strs[i].toCharArray();
            Arrays.sort(char_arr);
            String ans = new String(char_arr);
            space.add(Arrays.asList(ans, strs[i]));
        }
        Collections.sort(space, (l1, l2) -> l1.get(0).compareTo(l2.get(0)));
        List<List<String>> res = new ArrayList<>();
        List<String> firstGroup = new ArrayList<>();
        firstGroup.add(space.get(0).get(1));
        res.add(firstGroup);
        for(int i=1; i<space.size(); i++){
            if(space.get(i).get(0).equals(space.get(i-1).get(0))){
                res.get(res.size() - 1).add(space.get(i).get(1));
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(space.get(i).get(1));
                res.add(newGroup);
            }
        }
        return res;
        // if (strs.length == 0) return new ArrayList<>();
        
        // List<List<String>> space = new ArrayList<>();
        
        // for (int i = 0; i < strs.length; i++) {
        //     char[] charArr = strs[i].toCharArray();
        //     Arrays.sort(charArr);
        //     String sortedKey = new String(charArr);
        //     space.add(Arrays.asList(sortedKey, strs[i]));
        // }
        
        // Collections.sort(space, (l1, l2) -> l1.get(0).compareTo(l2.get(0)));
        
        // List<List<String>> res = new ArrayList<>();
        // List<String> currentGroup = new ArrayList<>();
        // currentGroup.add(space.get(0).get(1));
        // res.add(currentGroup);
        
        // for (int i = 1; i < space.size(); i++) {
        //     if (space.get(i).get(0).equals(space.get(i-1).get(0))) {
        //         // Same group - add to current group
        //         res.get(res.size() - 1).add(space.get(i).get(1));
        //     } else {
        //         // New group
        //         List<String> newGroup = new ArrayList<>();
        //         newGroup.add(space.get(i).get(1));
        //         res.add(newGroup);
        //     }
        // }
        
        // return res;
    }
}
