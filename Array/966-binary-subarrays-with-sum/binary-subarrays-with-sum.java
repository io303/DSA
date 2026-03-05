class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int count = 0;
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        
        for(int i=0; i<n; i++) {
            preSum += nums[i];

            int rem = preSum - goal;
            if(map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}    