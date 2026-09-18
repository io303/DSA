class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        help(nums, new ArrayList<>(), 0);
        return ans;
    }

    void help(int[] nums, List<Integer> curr, int start) {

        // Current subsequence valid hai
        if (curr.size() >= 2) {
            ans.add(new ArrayList<>(curr));
        }

        // Is level par kaunse values already use ho chuki hain
        Set<Integer> used = new HashSet<>();

        for (int j = start; j < nums.length; j++) {

            // Same level par same number dobara nahi lena
            if (used.contains(nums[j])) {
                continue;
            }

            // Non-decreasing condition
            if (!curr.isEmpty() &&
                nums[j] < curr.get(curr.size() - 1)) {
                continue;
            }

            used.add(nums[j]);

            // PICK
            curr.add(nums[j]);

            help(nums, curr, j + 1);

            // BACKTRACK
            curr.remove(curr.size() - 1);
        }
    }
}