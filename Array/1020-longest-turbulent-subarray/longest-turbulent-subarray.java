class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 1;
        }

        int ans = 1;
        int curr = 1;

        for (int i = 1; i < n; i++) {

            if (arr[i] > arr[i - 1]) {

                if (i >= 2 && arr[i - 1] > arr[i - 2]) {
                    // Same direction -> restart
                    curr = 2;
                } else {
                    // Opposite direction -> extend
                    curr++;
                }

            } else if (arr[i] < arr[i - 1]) {

                if (i >= 2 && arr[i - 1] < arr[i - 2]) {
                    // Same direction -> restart
                    curr = 2;
                } else {
                    // Opposite direction -> extend
                    curr++;
                }

            } else {
                // Equal elements break turbulence
                curr = 1;
            }

            ans = Math.max(ans, curr);
        }

        return ans;
    }
}