class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb,
                                 int start_node, int end_node) {

        List<List<Pair>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            g.get(u).add(new Pair(v, p));
            g.get(v).add(new Pair(u, p));
        }

        // Maximum probability till each node
        double[] maxProb = new double[n];

        maxProb[start_node] = 1.0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Double.compare(b.p, a.p));

        pq.add(new Pair(start_node, 1.0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            double prob = curr.p;

            // If destination reached, this is maximum probability
            if (node == end_node) {
                return prob;
            }

            // Ignore outdated entry
            if (prob < maxProb[node]) {
                continue;
            }

            for (Pair nei : g.get(node)) {

                double newProb = prob * nei.p;

                if (newProb > maxProb[nei.node]) {

                    maxProb[nei.node] = newProb;

                    pq.add(new Pair(nei.node, newProb));
                }
            }
        }

        return 0.0;
    }
}

class Pair {
    int node;
    double p;

    Pair(int node, double p) {
        this.node = node;
        this.p = p;
    }
}