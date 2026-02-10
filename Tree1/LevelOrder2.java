import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class LevelOrder2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, n);
        System.out.println(levelOrder(root));
    }

    // Build tree from array (level-wise)
    private static Node buildTree(int[] arr, int n) {
        if (n == 0 || arr[0] == -1) return null;

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < n) {
            Node curr = q.poll();

            // left child
            if (i < n) {
                if (arr[i] != -1) {
                    curr.left = new Node(arr[i]);
                    q.offer(curr.left);
                }
                i++;
            }

            // right child
            if (i < n) {
                if (arr[i] != -1) {
                    curr.right = new Node(arr[i]);
                    q.offer(curr.right);
                }
                i++;
            }
        }
        return root;
    }

    // Level order traversal
    private static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
