class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int maxi[]=new int[n];
        int mini[]=new int[n];
        maxi[0]=nums[0];

        for(int i=1;i<n;i++ ){
            maxi[i]=Math.max(nums[i],maxi[i-1]);
        }
        mini[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--){
            mini[i]=Math.min(nums[i],mini[i+1]);
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            if(maxi[i]-mini[i]<=k){
                ans=i;
                break;
            }
        }
        return ans;
    }
}