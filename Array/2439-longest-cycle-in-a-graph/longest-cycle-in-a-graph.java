class Solution {
    public int longestCycle(int[] edges) {

        int n = edges.length;
        boolean[] visited = new boolean[n];
        int ans = -1;

        for (int i = 0; i < n; i++) {

            if (visited[i]) continue;

            int curr = i;
            int step = 0;

            // current traversal ke nodes ka distance
            HashMap<Integer, Integer> map = new HashMap<>();

            while (curr != -1 && !visited[curr]) {

                visited[curr] = true;

                map.put(curr, step);

                step++;

                curr = edges[curr];
            }

            // curr kisi current path ke node mein mila?
            if (curr != -1 && map.containsKey(curr)) {

                int cycleLength = step - map.get(curr);

                ans = Math.max(ans, cycleLength);
            }
        }

        return ans;
    }
}