class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(0,path,res,graph);
        return res;
    }
    void dfs(int node ,List<Integer> path,List<List<Integer>> res,int grid[][]){
        if(node==grid.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int next:grid[node]){
            path.add(next);
            dfs(next,path,res,grid);
            path.remove(path.size()-1);
        }
    }
}