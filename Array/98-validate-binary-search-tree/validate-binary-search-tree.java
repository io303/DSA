class Solution {
    public boolean isValidBST(TreeNode root) {
        return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean help(TreeNode root, long low, long high){
        if(root == null) return true;

        if(root.val >= high || root.val <= low)
            return false;

        return help(root.left, low, root.val) &&
               help(root.right, root.val, high);
    }
}
