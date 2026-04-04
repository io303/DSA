class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 1) return nums[0];
        
        int l = help(0, n-2, nums);
        int r = help(1, n-1, nums);
        
        return Math.max(l, r);
    }

    int help(int s, int e, int[] arr){
        int dp[] = new int[arr.length];
        
        dp[s] = arr[s];
        if(s == e) return dp[s];
        
        dp[s+1] = Math.max(arr[s], arr[s+1]);

        for(int i = s+2; i <= e; i++){
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
        }

        return dp[e];
    }
}