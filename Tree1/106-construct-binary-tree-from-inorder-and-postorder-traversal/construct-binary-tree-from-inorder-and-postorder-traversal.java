class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int postindex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return help(inorder, postorder, 0, inorder.length - 1);
    }

    TreeNode help(int[] inorder, int[] postorder, int s, int e) {
        if (s > e) return null;

        int value = postorder[postindex--];
        TreeNode root = new TreeNode(value);

        int index = map.get(value);

        // RIGHT FIRST
        root.right = help(inorder, postorder, index + 1, e);
        root.left = help(inorder, postorder, s, index - 1);

        return root;
    }
}
