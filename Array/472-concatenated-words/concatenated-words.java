class Solution {
    public boolean concatable(String s, Set<String> set, Map<String, Boolean> memo){
        if(memo.containsKey(s) && !memo.get(s)) return false;
        for(int i=1; i<s.length(); i++){
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if(set.contains(prefix) && (set.contains(suffix) || concatable(suffix, set, memo))){
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Map<String, Boolean> memo = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String s : words){
            if(concatable(s, set, memo))
                res.add(s);
        }
        return res;
    }
}