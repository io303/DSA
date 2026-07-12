class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList<>());
        return ans;
    }

    void helper(TreeNode root, int target, int sum, List<Integer> path) {

        if (root == null)
            return;

        path.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null && sum == target) {
            ans.add(new ArrayList<>(path));
        }

        helper(root.left, target, sum, path);
        helper(root.right, target, sum, path);

        // Backtracking
        path.remove(path.size() - 1);
    }
}