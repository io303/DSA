class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        Queue<Tuple> q = new LinkedList<>();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        q.offer(new Tuple(0, src, 0));

        while (!q.isEmpty()) {

            Tuple cur = q.poll();

            if (cur.s > k)
                continue;

            for (Pair p : adj.get(cur.c)) {

                int newCost = cur.cost + p.w;

                if (newCost < dist[p.v]) {
                    dist[p.v] = newCost;
                    q.offer(new Tuple(cur.s + 1, p.v, newCost));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

class Pair {
    int v, w;

    Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

class Tuple {
    int s, c, cost;

    Tuple(int s, int c, int cost) {
        this.s = s;
        this.c = c;
        this.cost = cost;
    }
}