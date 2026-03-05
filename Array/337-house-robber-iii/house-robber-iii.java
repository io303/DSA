/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode,Integer> map=new HashMap<>();
        return help(root,map);
    }
    int help(TreeNode root,Map<TreeNode,Integer> map){
        if(root==null) return 0;
        if(map.containsKey(root)){
            return map.get(root);
        }
        int val=0;
        if(root.left!=null){
            val+=help(root.left.left,map) +help(root.left.right,map);
        }
        if(root.right!=null){
            val+=help(root.right.left,map)+help(root.right.right,map);
        }
        val=Math.max(val+root.val,help(root.left,map)+help(root.right,map));
        map.put(root,val);
        return val;
    }
}