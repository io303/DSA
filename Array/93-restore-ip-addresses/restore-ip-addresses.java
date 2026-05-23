class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        if(s.length()<4||s.length()>12)return ans;
        solve(0,0,"",s,ans);
        return ans;
    }
    void solve(int idx,int parts,String curr,String s,List<String> ans){

        if(parts==4&&idx==s.length()){
            ans.add(curr.substring(0,curr.length()-1));
            return;
        }
        if(parts>4)return;

        for(int len=1;len<=3;len++){
            if(idx+len>s.length()) break;
            String part=s.substring(idx,idx+len);
            if(part.length()>1&&part.charAt(0)=='0')continue;
            int num=Integer.parseInt(part);
            if(num<=255){
                solve(idx+len,parts+1,curr+part+".",s,ans);
            }
        }
    }
}