class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int l=1;
        int r=Integer.MIN_VALUE;
        for(int num:nums){
            r=Math.max(num,r);
        }
        int  ans=0;
        
            while(l<r){
                int mid=l+(r-l)/2;
                if(canMake(mid,nums,threshold)){
                    r=mid;
                }else{
                    l=mid+1;
                }
                
            }
            return l;
    }
    boolean canMake(int val,int nums[],int h){
        int t=0;
        for(int num:nums){
            t+=(num+val-1)/val;
        }
        return t<=h;
    }
}