class Solution {
    public String customSortString(String order, String s) {

        int[] freq = new int[26];

        // count frequency
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        StringBuilder res = new StringBuilder();

        // add characters according to order
        for(char ch : order.toCharArray()){

            while(freq[ch - 'a'] > 0){
                res.append(ch);
                freq[ch - 'a']--;
            }
        }

        // add remaining characters
        for(char ch : s.toCharArray()){

            if(freq[ch - 'a'] > 0){
                res.append(ch);
                freq[ch - 'a']--;
            }
        }

        return res.toString();
    }
}