import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        // value -> all indices having this value
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>())
               .add(i);
        }

        Queue<Integer> q = new LinkedList<>();

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        q.offer(0);
        dist[0] = 0;

        while (!q.isEmpty()) {

            int i = q.poll();

            int steps = dist[i];

            // Reached destination
            if (i == n - 1) {
                return steps;
            }

            // 1. i - 1
            if (i - 1 >= 0 && dist[i - 1] == -1) {

                dist[i - 1] = steps + 1;
                q.offer(i - 1);
            }

            // 2. i + 1
            if (i + 1 < n && dist[i + 1] == -1) {

                dist[i + 1] = steps + 1;
                q.offer(i + 1);
            }

            // 3. Same value
            List<Integer> sameValue = map.get(arr[i]);

            for (int next : sameValue) {

                if (dist[next] == -1) {

                    dist[next] = steps + 1;
                    q.offer(next);
                }
            }

            // VERY IMPORTANT
            sameValue.clear();
        }

        return -1;
    }
}