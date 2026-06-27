class Solution {

    List<Integer> inorderList = new ArrayList<>();
    int index = 0;

    public void recoverTree(TreeNode root) {

        // Step 1: Store inorder
        inorder(root);

        // Step 2: Sort
        Collections.sort(inorderList);

        // Step 3: Put sorted values back
        restore(root);
    }

    private void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }

    private void restore(TreeNode root) {

        if (root == null)
            return;

        restore(root.left);
        root.val = inorderList.get(index++);
        restore(root.right);
    }
}