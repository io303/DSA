class Solution {
    public int numOfSubarrays(int[] arr) {
        long odd = 0, even = 1;  // prefix = 0 counted as even
        long prefix = 0;
        long result = 0;
        long MOD = 1_000_000_007;

        for (int num : arr) {
            prefix += num;

            if (prefix % 2 == 0) {
                // even prefix: it forms odd subarrays with previous odd prefixes
                result = (result + odd) % MOD;
                even++;
            } else {
                // odd prefix: it forms odd subarrays with previous even prefixes
                result = (result + even) % MOD;
                odd++;
            }
        }

        return (int) result;
    }
}
