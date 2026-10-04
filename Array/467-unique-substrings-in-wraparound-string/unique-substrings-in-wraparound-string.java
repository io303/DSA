class Solution {
    public int findSubstringInWraproundString(String s) {
        int n=s.length();
        int dp[]=new int[26];
        int curr=1;
        for(int i=0;i<n;i++){
            if(i>0&&(s.charAt(i)-s.charAt(i-1)+26)%26==1){
                curr++;
            }else{
                curr=1;
            }
            int index=s.charAt(i)-'a';
            dp[index]=Math.max(dp[index],curr);
        }
        int ans=0;
        for(int a:dp){
            ans+=a;
        }
        return ans;
    }
}