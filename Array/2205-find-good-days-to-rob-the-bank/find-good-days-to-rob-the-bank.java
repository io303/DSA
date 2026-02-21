class Solution {
    // Function to find the good days to rob the bank
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        // Size of the security array
        int n = security.length;

        // Auxiliary arrays to store the lengths of non-increasing and non-decreasing sequences
        int[] prefix = new int[n]; 
        int[] suffix = new int[n];

        // Fill the prefix array (non-increasing sequence)
        for (int i = 1; i < n; i++) {
            // If current value is less than or equal to the previous value
            if (security[i - 1] >= security[i]) {
                // Increment the count of non-increasing days
                prefix[i] = prefix[i - 1] + 1;
            }
        }

        // Fill the suffix array (non-decreasing sequence)
        for (int i = n - 2; i >= 0; i--) {
            // If current value is less than or equal to the next value
            if (security[i + 1] >= security[i]) {
                // Increment the count of non-decreasing days
                suffix[i] = suffix[i + 1] + 1;
            }
        }

        // List to store the result (good days)
        List<Integer> ans = new ArrayList<>();

        // Check each day to see if it's a good day to rob the bank
        for (int i = 0; i < n; i++) {
            // If both prefix and suffix conditions are satisfied
            if (prefix[i] >= time && suffix[i] >= time) {
                // Add the index to the result list
                ans.add(i);
            }
        }

        // Return the list of good days
        return ans;
    }
}
