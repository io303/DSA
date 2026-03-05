import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class trr {
     static List<Integer>[] tree;
    static Map<Long, Integer> map;
    static int idCounter;
    static final long P = 91138233L;

    static int dfs(int node, int[] hashArr) {
        List<Integer> childHashes = new ArrayList<>();

        for (int child : tree[node]) {
            childHashes.add(dfs(child, hashArr));
        }

        Collections.sort(childHashes);

        long hash = 1;
        for (int h : childHashes) {
            hash = hash * P + h;
        }

        if (!map.containsKey(hash)) {
            map.put(hash, ++idCounter);
        }

        hashArr[node] = map.get(hash);
        return hashArr[node];
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();

        while (T-- > 0) {

            int N1 = fs.nextInt();
            int N2 = fs.nextInt();

            // -------- TREE 1 ----------
            tree = new ArrayList[N1 + 1];
            for (int i = 1; i <= N1; i++)
                tree[i] = new ArrayList<>();

            for (int i = 2; i <= N1; i++) {
                int parent = fs.nextInt();
                tree[parent].add(i);
            }

            map = new HashMap<>(N1 * 2);
            idCounter = 0;

            int[] hash1 = new int[N1 + 1];
            dfs(1, hash1);

            Set<Integer> leafTypes = new HashSet<>();
            for (int i = 1; i <= N1; i++) {
                if (tree[i].isEmpty()) {
                    leafTypes.add(hash1[i]);
                }
            }

            int Y = leafTypes.size();

            // -------- TREE 2 ----------
            tree = new ArrayList[N2 + 1];
            for (int i = 1; i <= N2; i++)
                tree[i] = new ArrayList<>();

            for (int i = 2; i <= N2; i++) {
                int parent = fs.nextInt();
                tree[parent].add(i);
            }

            map = new HashMap<>(N2 * 2);
            idCounter = 0;

            int[] hash2 = new int[N2 + 1];
            dfs(1, hash2);

            Set<Integer> subtreeTypes = new HashSet<>();
            for (int i = 1; i <= N2; i++) {
                subtreeTypes.add(hash2[i]);
            }

            int X = subtreeTypes.size();

            out.append((long) X * Y).append("\n");
        }

        System.out.print(out);
    }
}
