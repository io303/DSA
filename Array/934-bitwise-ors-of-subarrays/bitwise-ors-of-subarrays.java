class Solution {
    public int subarrayBitwiseORs(int[] arr) {

        Set<Integer> answer = new HashSet<>();

        Set<Integer> prev = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            Set<Integer> curr = new HashSet<>();

            // Subarray [arr[i]]
            curr.add(arr[i]);

            // Extend every subarray ending at i-1
            for (int x : prev) {
                curr.add(x | arr[i]);
            }

            // Store all distinct ORs
            answer.addAll(curr);

            // Move to next index
            prev = curr;
        }

        return answer.size();
    }
}