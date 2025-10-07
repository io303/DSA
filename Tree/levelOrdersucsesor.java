package Tree;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class levelOrdersucsesor {
    public TreeNode Succsesor(TreeNode root){
        if(root==null){
            return null;
        }
         Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
        int levelSize = queue.size();
        TreeNode currentNode = queue.poll();
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
        if (currentNode.val = key) {
          break;
        }
    }
    return queue.peek(); 
    
    }
    
}
