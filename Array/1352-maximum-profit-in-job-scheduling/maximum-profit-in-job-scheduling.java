class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
 
		int len = startTime.length;
		int[][] jobs = new int[len][3];
		for (int i = 0; i < len; i++) {
			jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
		}
		Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

		return dfs(0, jobs, new Integer[len]);
	}

	private int dfs(int cur, int[][] jobs, Integer[] memo) {
		if (cur == jobs.length) return 0;
		if (memo[cur] != null) return memo[cur];

		int inclProf = jobs[cur][2] + dfs(findNext(cur, jobs), jobs, memo);
		int exclProf = dfs(cur + 1, jobs, memo);

		return memo[cur] = Math.max(inclProf, exclProf);
	}

	private int findNext(int cur, int[][] jobs) {
		for (int next = cur + 1; next < jobs.length; next++) {
			if (jobs[next][0] >= jobs[cur][1]) {
				return next;
			}
		}
		return jobs.length;
	}
    }
