class Solution {

    Integer[] dp;

    public int minHeightShelves(int[][] books, int shelfWidth) {

        dp = new Integer[books.length];

        return help(0, books, shelfWidth);
    }

    int help(int i, int[][] books, int shelfWidth) {

        // All books placed
        if (i == books.length) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int width = 0;
        int height = 0;

        int ans = Integer.MAX_VALUE;

        // Try putting consecutive books on current shelf
        for (int j = i; j < books.length; j++) {

            width += books[j][0];

            // Cannot fit more books
            if (width > shelfWidth) {
                break;
            }

            height = Math.max(height, books[j][1]);

            // Current shelf height + remaining shelves
            ans = Math.min(
                ans,
                height + help(j + 1, books, shelfWidth)
            );
        }

        return dp[i] = ans;
    }
}