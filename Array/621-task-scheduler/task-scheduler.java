class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : map.values()) {
            pq.offer(freq);
        }

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1;
            int workDone = 0;

            while (cycle > 0 && !pq.isEmpty()) {

                int freq = pq.poll();
                workDone++;

                if (freq > 1) {
                    temp.add(freq - 1);
                }

                cycle--;
            }

            for (int f : temp) {
                pq.offer(f);
            }

            if (pq.isEmpty()) {
                time += workDone;
            } else {
                time += (n + 1);
            }
        }

        return time;
    }
}