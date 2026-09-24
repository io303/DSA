class Solution {
    public int smallestIndex(int[] nums) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(help(i,nums[i])){
                ans=Math.min(i,ans);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    boolean help(int i,int n){
        int c=0;
        while(n>0){
            int  rem=n%10;
            c+=rem;
            n/=10;

        }
        return c==i;
    }
}