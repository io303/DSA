class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans=new ArrayList<>();

        if(n==1){
            ans.add(0);
            return ans;
        }
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());

        }

        for(int a[]:edges){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);

        }

        int degree[]=new int[n];

        for(int i=0;i<n;i++){
            degree[i]=adj.get(i).size();
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.offer(i);
            }
        }
        int rem=n;

        while(rem>2){
            int size=q.size();
            rem-=size;

            while(size-->0){
                int l=q.poll();

                for(int nei:adj.get(l)){
                    degree[nei]--;

                    if(degree[nei]==1){
                        q.offer(nei);
                    }
                }
            }
        }
         while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }
}