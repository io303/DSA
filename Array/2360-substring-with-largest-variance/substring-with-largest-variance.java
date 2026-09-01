class Solution {
    public int largestVariance(String s) {
        int ans = 0;

        for (char major = 'a'; major <= 'z'; major++) {
            for (char minor = 'a'; minor <= 'z'; minor++) {

                if (major == minor) continue;

                int majorCount = 0;
                int minorCount = 0;
                int remainingMinor = 0;

                // Count how many minor characters remain
                for (char c : s.toCharArray()) {
                    if (c == minor) {
                        remainingMinor++;
                    }
                }

                for (char c : s.toCharArray()) {

                    if (c == major) {
                        majorCount++;
                    }

                    if (c == minor) {
                        minorCount++;
                        remainingMinor--;
                    }

                    // Valid substring: it contains at least one minor
                    if (minorCount > 0) {
                        ans = Math.max(ans, majorCount - minorCount);
                    }

                    // If minor characters are currently hurting us,
                    // reset only when another minor is still available.
                    if (minorCount > majorCount && remainingMinor > 0) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
            }
        }

        return ans;
    }
}