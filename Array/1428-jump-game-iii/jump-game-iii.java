class Solution {

    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        return dfs(start, arr, vis);
    }

    boolean dfs(int i, int[] arr, boolean[] vis) {

        if (i < 0 || i >= arr.length || vis[i]) {
            return false;
        }

        if (arr[i] == 0) {
            return true;
        }

        vis[i] = true;

        return dfs(i + arr[i], arr, vis) ||
               dfs(i - arr[i], arr, vis);
    }

   
}