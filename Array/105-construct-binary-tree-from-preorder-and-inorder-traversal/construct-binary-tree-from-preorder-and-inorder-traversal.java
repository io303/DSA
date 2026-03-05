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
    int preindex=0;
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return help(preorder,0,n-1);

    }
    TreeNode help(int preorder[],int l,int r){
        if(l>r) return null;
        int rootval=preorder[preindex++];
        TreeNode root=new TreeNode(rootval);
        int index=map.get(rootval);

        root.left=help(preorder,l,index-1);
        root.right=help(preorder,index+1,r);
        return root;
    }
}