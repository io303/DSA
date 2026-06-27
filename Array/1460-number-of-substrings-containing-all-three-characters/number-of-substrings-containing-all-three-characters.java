class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();
        int i = 0, j = 0;
        int ans = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (j < n) {

            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() == 3) {

                // Current window has a,b,c
                ans += n - j;

                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }

                i++;
            }

            j++;
        }

        return ans;
    }
}