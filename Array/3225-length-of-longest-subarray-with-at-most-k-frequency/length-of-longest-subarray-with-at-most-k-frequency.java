class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        int  i=0,j=0,n=nums.length,maxi=Integer.MIN_VALUE;
        while(j<n){
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);

            while(mp.get(nums[j])>k){
                mp.put(nums[i],mp.get(nums[i])-1);
                if(mp.get(nums[i])==0)mp.remove(nums[i]);
                i++;
            }
            maxi=Math.max(maxi,j-i+1);
            j++;
        }
        return maxi;
    }
}