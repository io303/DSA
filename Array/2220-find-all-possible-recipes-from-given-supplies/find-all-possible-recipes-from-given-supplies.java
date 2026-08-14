class Solution {
    public List<String> findAllRecipes(
            String[] recipes,
            List<List<String>> ingredients,
            String[] supplies) {

        // ingredient -> recipes that need this ingredient
        Map<String, List<String>> graph = new HashMap<>();

        // Number of ingredients still required
        Map<String, Integer> indegree = new HashMap<>();

        // Build graph
        for (int i = 0; i < recipes.length; i++) {

            String recipe = recipes[i];

            indegree.put(recipe, ingredients.get(i).size());

            for (String ingredient : ingredients.get(i)) {

                graph
                    .computeIfAbsent(
                        ingredient,
                        k -> new ArrayList<>()
                    )
                    .add(recipe);
            }
        }

        // Initially available supplies
        Queue<String> q = new LinkedList<>();

        for (String supply : supplies) {
            q.offer(supply);
        }

        List<String> ans = new ArrayList<>();

        // BFS
        while (!q.isEmpty()) {

            String ingredient = q.poll();

            // Recipes which need this ingredient
            if (!graph.containsKey(ingredient)) {
                continue;
            }

            for (String recipe : graph.get(ingredient)) {

                indegree.put(
                    recipe,
                    indegree.get(recipe) - 1
                );

                // All ingredients available
                if (indegree.get(recipe) == 0) {

                    ans.add(recipe);

                    // Recipe becomes a new supply
                    q.offer(recipe);
                }
            }
        }

        return ans;
    }
}