class Solution {
    public int maximumPopulation(int[][] logs) {

        int[] diff = new int[2051];

        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];

            diff[birth]++;
            diff[death]--;
        }

        int population = 0;
        int maxPopulation = 0;
        int answer = 0;

        for (int year = 1950; year <= 2050; year++) {

            population += diff[year];

            if (population > maxPopulation) {
                maxPopulation = population;
                answer = year;
            }
        }

        return answer;
    }
}