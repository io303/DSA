import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cousine8 {

  static boolean isCousins(TreeNode root, int x, int y){
    if(root==null){
        return false;
    }
    TreeNode xx=findNode(root,x);
        TreeNode yy=findNode(root,y);
        return((level(root,xx,0)==level(root,yy,0))&&(!isSibling(root,xx,yy)));
    }


    static TreeNode findNode(TreeNode node,int x){
        if(node==null){
            return null;
        }
        if(node.val==x){
            return node;
        }
        TreeNode n=findNode(node.left,x);
        if(n!=null){
            return n;
        }
        return findNode(node.right,x);
    }

     static int level(TreeNode node,TreeNode x,int lev){
        if(node==null){
            return 0;
        }
        if(node.val==x.val){
            return lev;
        }
        int l=level(node.left,x,lev+1);
        if(l!=0){
            return l;
        }
        return level(node.right,x,lev+1);
    }
    public static boolean isSibling(TreeNode node,TreeNode x,TreeNode y){
        if(node==null){
            return false;
        }
        return  (
      (node.left == x && node.right == y) || (node.left == y && node.right == x)
      || isSibling(node.left, x, y) || isSibling(node.right, x, y)
    );
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
            int x=scanner.nextInt();
            int y=scanner.nextInt();

        TreeNode root = buildTreeFromArray(arr);
      boolean z=isCousins(root, x, y);
        System.out.println("Next pointers by level:"+z);
       
    }
}

class TreeNode {
    int val;
    TreeNode left, right, next;

    TreeNode(int val) {
        this.val = val;
    }
}
