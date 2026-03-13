class Solution {

    static int n;
    static int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

    public static int largestIsland(int[][] grid) {

        n=grid.length;

        HashMap<Integer,Integer> map=new HashMap<>();
        int id=2;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int size=dfs(grid,i,j,id);
                    map.put(id,size);
                    id++;
                }
            }
        }

        int ans=0;

        for(int val:map.values())
            ans=Math.max(ans,val);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==0){

                    HashSet<Integer> set=new HashSet<>();

                    for(int d[]:dirs){
                        int r=i+d[0];
                        int c=j+d[1];

                        if(r>=0 && c>=0 && r<n && c<n && grid[r][c]>1)
                            set.add(grid[r][c]);
                    }

                    int size=1;

                    for(int island:set)
                        size+=map.get(island);

                    ans=Math.max(ans,size);
                }
            }
        }

        return ans;
    }

    static int dfs(int[][] grid,int r,int c,int id){

        if(r<0 || c<0 || r>=n || c>=n || grid[r][c]!=1)
            return 0;

        grid[r][c]=id;

        int size=1;

        for(int d[]:dirs)
            size+=dfs(grid,r+d[0],c+d[1],id);

        return size;
    }
}
