class Solution {
    public int countBattleships(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] != 'X')
                    continue;

                // If there is X above, this is not the starting cell
                if (i > 0 && board[i - 1][j] == 'X')
                    continue;

                // If there is X on left, this is not the starting cell
                if (j > 0 && board[i][j - 1] == 'X')
                    continue;

                // This is the top-left cell of a battleship
                ans++;
            }
        }

        return ans;
    }
}