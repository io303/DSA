class Solution {
    public int tribonacci(int n) {
        // Base cases for small n
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Array size n + 1 to include the nth index
        int arr[] = new int[n + 1];
        Arrays.fill(arr, -1);
        return help(n, arr);
    }

    int help(int i, int arr[]) {
        // Standard Tribonacci base cases
        if (i == 0) return 0;
        if (i == 1 || i == 2) return 1;

        // Memoization check
        if (arr[i] != -1) return arr[i];

        // Recursive step: T(n) = T(n-1) + T(n-2) + T(n-3)
        // Ensure you are calling the function recursively, not accessing the array directly
        return arr[i] = help(i - 1, arr) + help(i - 2, arr) + help(i - 3, arr);
    }
}