class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        int cnt = 0, oddCnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i=0; i<n; i++) {
            oddCnt += nums[i] % 2;
            int rem = oddCnt - k;

            if(map.containsKey(rem)) {
                cnt += map.get(rem);
            }

            map.put(oddCnt, map.getOrDefault(oddCnt, 0) + 1);
        }

        return cnt;
    }
} 