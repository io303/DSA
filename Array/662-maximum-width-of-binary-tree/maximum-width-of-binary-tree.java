import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int start = q.peek().index;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int idx = curr.index - start; // normalize

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (curr.node.left != null)
                    q.offer(new Pair(curr.node.left, 2 * idx));

                if (curr.node.right != null)
                    q.offer(new Pair(curr.node.right, 2 * idx + 1));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}