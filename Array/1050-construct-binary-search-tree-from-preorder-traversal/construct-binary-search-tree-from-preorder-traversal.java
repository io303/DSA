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
    int i=0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    TreeNode help(int arr[],int l,int h){
        if(i>=arr.length) return null;
        int valu=arr[i];
        if(valu>=h||valu<=l) return null;
        i++;
        TreeNode root=new TreeNode(valu);
        root.left=help(arr,l,valu);
        root.right=help(arr,valu,h);
        return root;
    }
}