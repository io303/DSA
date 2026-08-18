class Solution {

    int[] parent;
    int[] rank;

    public List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        int n = accounts.size();

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // email -> account index
        Map<String, Integer> emailToAccount = new HashMap<>();

        // Step 1: Union accounts having common email
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < accounts.get(i).size(); j++) {

                String email = accounts.get(i).get(j);

                if (emailToAccount.containsKey(email)) {

                    int oldAccount = emailToAccount.get(email);

                    union(i, oldAccount);

                } else {

                    emailToAccount.put(email, i);
                }
            }
        }

        // Step 2: Group emails according to root
        Map<Integer, List<String>> groups = new HashMap<>();

        for (String email : emailToAccount.keySet()) {

            int account = emailToAccount.get(email);

            int root = find(account);

            groups.putIfAbsent(root, new ArrayList<>());

            groups.get(root).add(email);
        }

        // Step 3: Create answer
        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : groups.entrySet()) {

            int root = entry.getKey();

            List<String> emails = entry.getValue();

            Collections.sort(emails);

            List<String> temp = new ArrayList<>();

            // Name
            temp.add(accounts.get(root).get(0));

            // Emails
            temp.addAll(emails);

            ans.add(temp);
        }

        return ans;
    }

    int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        }
        else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        }
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}