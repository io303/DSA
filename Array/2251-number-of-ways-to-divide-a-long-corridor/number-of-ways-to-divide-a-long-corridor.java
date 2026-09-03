class Solution {
    public int numberOfWays(String corridor) {

        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        int seat = 0;

        for (int i = 0; i < corridor.length(); i++) {

            if (corridor.charAt(i) == 'S') {
                seat++;

                if (seat % 2 == 1) {
                    // start of pair
                    start.add(i);
                } else {
                    // end of pair
                    end.add(i);
                }
            }
        }

        // Invalid if seats are 0 or odd
        if (seat == 0 || seat % 2 != 0) {
            return 0;
        }

        long ans = 1;
        int MOD = 1_000_000_007;

        // Multiply choices between consecutive pairs
        for (int i = 1; i < start.size(); i++) {

            int ways = start.get(i) - end.get(i - 1);

            ans = (ans * ways) % MOD;
        }

        return (int) ans;
    }
}