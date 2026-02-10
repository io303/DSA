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
    List<String> res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return  res;

        help(root,"");
        return res;
    }
    void help(TreeNode node ,String path){
        if(node==null) return;

        path+=node.val;
        if(node.left==null&& node.right==null){
            res.add(path);
            return;
        }
        help(node.left,path+"->");
        help(node.right,path+"->");
    }
}