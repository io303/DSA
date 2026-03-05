class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        int index=0;
        while(!q.isEmpty()){
            index+=k;
            for(int i=0;i<index-1;i++){
                int e=q.poll();
                q.add(e);
            }
            q.poll();
            if(q.size()==1){
                return q.poll();
            }
            index=0;
        }
        return 1;
    }
}