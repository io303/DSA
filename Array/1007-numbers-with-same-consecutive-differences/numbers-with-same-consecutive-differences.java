class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<String> ls=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
       help(n,k,ls,sb);
       int ans[]=new int[ls.size()];
       for(int i=0;i<ls.size();i++){
        ans[i]=Integer.parseInt(ls.get(i));
       }
       return ans;
    }
    void help(int n,int k,List<String> ans,StringBuilder sb){
        if(sb.length()==n){
            ans.add(sb.toString());
            return;
        }
        for(int i=0;i<=9;i++){
            if(sb.isEmpty()&&i==0)continue;
            if(!sb.isEmpty()&&(Math.abs((sb.charAt(sb.length()-1)-'0')-i))!=k)continue;
            sb.append(i);
            help(n,k,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        
        }
    }
}