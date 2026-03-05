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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        Set<TreeNode> st=new HashSet<>();
        buildParent(root,null,map);
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode srt=Findsrt(root,start);
        q.add(srt);
        st.add(srt);
        int d=-1;
        while(!q.isEmpty()){
            int size=q.size();
            d++;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                if(node.left!=null&& !st.contains(node.left)){
                    q.add(node.left);
                    st.add(node.left);
                }
                if(node.right!=null&& !st.contains(node.right)){
                    q.add(node.right);
                    st.add(node.right);
                }
                TreeNode par=map.get(node);
                if(par!=null && !st.contains(par)){
                    q.offer(par);
                    st.add(par);
                }
            }

        }
        return d;
    }

    void buildParent(TreeNode root,TreeNode parent,Map<TreeNode,TreeNode> map){
        if(root==null) return ;
        map.put(root,parent);
        buildParent(root.left,root,map);
        buildParent(root.right,root,map);
    }
    TreeNode Findsrt(TreeNode root,int start){
        if(root==null) return null;
        if(root.val==start) return root;
        TreeNode le=Findsrt(root.left,start);
        if(le!=null) return le;
        return Findsrt(root.right,start);
    }
}