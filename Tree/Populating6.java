import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Populating6 {

    // Populates next pointers
    static TreeNode populating(TreeNode node){
        if (node == null) return null;

        TreeNode leftmost = node;
        while (leftmost.left != null) {
            TreeNode current = leftmost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return node;
    }

    // Builds tree from level-order array (-1 represents null)
    static TreeNode buildTreeFromArray(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (current == null) continue;

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    // Traverse tree level by level using next pointers
    static void printNextPointers(TreeNode root) {
        TreeNode leftmost = root;
        while (leftmost != null) {
            TreeNode current = leftmost;
            while (current != null) {
                System.out.print(current.val + " -> ");
                if (current.next != null) {
                    System.out.print(current.next.val + "  ");
                } else {
                    System.out.print("null  ");
                }
                current = current.next;
            }
            System.out.println();
            leftmost = leftmost.left;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements in level order (-1 for null): ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        TreeNode root = buildTreeFromArray(arr);
        populating(root);
        System.out.println("Next pointers by level:");
        printNextPointers(root);
    }
}

class TreeNode {
    int val;
    TreeNode left, right, next;

    TreeNode(int val) {
        this.val = val;
    }
}
