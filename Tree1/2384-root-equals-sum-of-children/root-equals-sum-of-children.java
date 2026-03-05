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
    public boolean checkTree(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        int l=0,r=0;
        if(root.left!=null){
            l=root.left.val;

        }
        if(root.right!=null){
            r=root.right.val;
        }
        if(root.val==l+r &&checkTree(root.left)&& checkTree(root.right)) return true;
        return false;
    }
}