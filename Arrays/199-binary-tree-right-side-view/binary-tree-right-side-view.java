class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode node, int level) {
        if (node == null) return;

        // first node at this level
        if (level == res.size()) {
            res.add(node.val);
        }

        // go RIGHT first
        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }
}
