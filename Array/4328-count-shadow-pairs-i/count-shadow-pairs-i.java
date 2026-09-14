class Solution {
    public long shadowPairs(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length; 
        int next[] = new int[n]; 
        HashMap<Integer, List<Integer>> freq = new HashMap<>();
        // find position of right side smaller for each index 
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop(); // remove 
            }

            next[i] = stack.isEmpty() ? n : stack.peek(); 
            stack.push(i); // push the current index 
        }
        for(int i = 0; i < n; i++) {
            freq.putIfAbsent(nums[i], new ArrayList<>()); 
            freq.get(nums[i]).add(i); 
        }

        long ans = 0; 
        for(int i = 0; i < n; i++) {
            long len = next[i] - i; 
            ans += len - getEqual(freq.get(nums[i]), i, next[i]); // means remove all equal to nums[i] in range [i...next[i]]
        }
        return ans; 
    }

    private int getEqual(List<Integer> f, int st, int en) {
        // How many elementes are there in range [st, en] inclusive we can use bs to find position of each index.
        // find lowerbound for each 
        return bs(f, en) - bs(f, st); 
    }

    private int bs(List<Integer> f, int tar) {
        int lo = 0, hi = f.size() - 1; 
        int ans = f.size(); 
        while(lo <= hi) {
            int mid = (lo + hi) >> 1; 

            if(f.get(mid) == tar) return mid; 
            if(f.get(mid) > tar) {
                // ans in left 
                ans = mid; 
                hi = mid - 1; 
            } else lo = mid + 1; 
        }
        return ans; 
    }
}