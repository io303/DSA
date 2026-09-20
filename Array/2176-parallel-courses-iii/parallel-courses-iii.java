import java.util.*;

class Solution {

    List<List<Integer>> graph;
    int[] time;
    int[] dp;

    public int minimumTime(int n, int[][] relations, int[] time) {

        this.time = time;

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // prerequisite -> course
        for (int[] relation : relations) {

            int u = relation[0];
            int v = relation[1];

            graph.get(u).add(v);
        }

        // dp[i] = minimum time to complete course i
        dp = new int[n + 1];

        int answer = 0;

        // Try every course
        for (int i = 1; i <= n; i++) {

            answer = Math.max(answer, dfs(i));
        }

        return answer;
    }

    private int dfs(int course) {

        // Already calculated
        if (dp[course] != 0) {
            return dp[course];
        }

        // Course itself takes time[course - 1]
        int maxPrerequisiteTime = 0;

        for (int next : graph.get(course)) {

            maxPrerequisiteTime =
                Math.max(maxPrerequisiteTime, dfs(next));
        }

        dp[course] = maxPrerequisiteTime + time[course - 1];

        return dp[course];
    }
}