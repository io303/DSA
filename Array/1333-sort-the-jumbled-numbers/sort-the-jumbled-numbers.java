class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {

        Map<Integer, List<Integer>> mp = new TreeMap<>();

        for (int original : nums) {

            int a = original;
            int mapped = 0;
            int place = 1;

            if (a == 0) {
                mapped = mapping[0];
            } else {
                while (a > 0) {
                    int rem = a % 10;

                    mapped += mapping[rem] * place;

                    place *= 10;
                    a /= 10;
                }
            }

            // duplicate mapped value ko list mein rakho
            mp.computeIfAbsent(mapped, k -> new ArrayList<>())
              .add(original);
        }

        int[] res = new int[nums.length];
        int k = 0;

        for (List<Integer> list : mp.values()) {
            for (int num : list) {
                res[k++] = num;
            }
        }

        return res;
    }
}