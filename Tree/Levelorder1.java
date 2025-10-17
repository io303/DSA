import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Levelorder1 {
    public List<List<Integer>> levelorder(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if(root=null){
            return res;
        }
        Queue<E> <TreeNode> queue=new linkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
        int n=queue.size();
        List<Integer> curr=new Arraylist<>();
        for(int i=0;i<n;i++){
            TreeNode current =queue.poll();
            curr.add(current.val);
            if(current.left!=null){
                queue.offer(current.left);

            }
            if(current.right!=null){
                queue.offer(current.right);
            }
        }
        result.add(current);
        }
        return res;
    }




}
