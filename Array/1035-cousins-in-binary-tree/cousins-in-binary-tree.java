class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if (curr.val == x) foundX = true;
                if (curr.val == y) foundY = true;

                // Check if x and y are siblings
                if (curr.left != null && curr.right != null) {
                    int left = curr.left.val;
                    int right = curr.right.val;

                    if ((left == x && right == y) ||
                        (left == y && right == x)) {
                        return false;
                    }
                }

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            if (foundX && foundY) return true;
            if (foundX || foundY) return false;
        }

        return false;
    }
}