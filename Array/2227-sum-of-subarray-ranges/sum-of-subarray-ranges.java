class Solution {

    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    private long sumMin(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() &&
                   nums[st.peek()] > nums[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() &&
                   nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long l = i - left[i];
            long r = right[i] - i;

            sum += (long) nums[i] * l * r;
        }

        return sum;
    }

    private long sumMax(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Greater
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() &&
                   nums[st.peek()] < nums[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() &&
                   nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long l = i - left[i];
            long r = right[i] - i;

            sum += (long) nums[i] * l * r;
        }

        return sum;
    }
}