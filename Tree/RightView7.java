import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;



public class RightView7 {
    static  List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();

      for (int i=0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();

        if (i == levelSize - 1) {
          result.add(currentNode.val);
        }
        
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
      }
    }
    return result;
    }
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
      List<Integer> res= rightSideView(root);
        System.out.println("Next pointers by level:"+res);
       
    }
}

class TreeNode {
    int val;
    TreeNode left, right, next;

    TreeNode(int val) {
        this.val = val;
    }

}
