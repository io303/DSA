class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int ans = 0;

        for (int x : arr1) {
            int l = 0;
            int h = arr2.length - 1;

            while (l <= h) {
                int mid = l + (h - l) / 2;

                if (arr2[mid] < x - d) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }

            // l = first index where arr2[l] >= x-d
            if (l == arr2.length || arr2[l] > x + d) {
                ans++;
            }
        }

        return ans;
    }
}