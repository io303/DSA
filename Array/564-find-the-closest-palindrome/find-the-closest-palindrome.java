class Solution {

    public String nearestPalindromic(String n) {

        int len = n.length();

        // Boundary candidates
        long allNine = (long) Math.pow(10, len - 1) - 1;
        long oneZeroOne = (long) Math.pow(10, len) + 1;

        long num = Long.parseLong(n);

        long prefix = Long.parseLong(
            n.substring(0, (len + 1) / 2)
        );

        long[] candidates = new long[5];

        candidates[0] = makePalindrome(prefix - 1, len);
        candidates[1] = makePalindrome(prefix, len);
        candidates[2] = makePalindrome(prefix + 1, len);
        candidates[3] = allNine;
        candidates[4] = oneZeroOne;

        long answer = -1;
        long minDiff = Long.MAX_VALUE;

        for (long candidate : candidates) {

            // Original number itself cannot be answer
            if (candidate == num) {
                continue;
            }

            long diff = Math.abs(candidate - num);

            if (diff < minDiff ||
                (diff == minDiff && candidate < answer)) {

                minDiff = diff;
                answer = candidate;
            }
        }

        return String.valueOf(answer);
    }

    private long makePalindrome(long prefix, int len) {

        String s = String.valueOf(prefix);

        StringBuilder sb = new StringBuilder(s);

        int start = (len % 2 == 0)
                ? s.length() - 1
                : s.length() - 2;

        for (int i = start; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return Long.parseLong(sb.toString());
    }
}