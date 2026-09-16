class Solution {

    public String makeLargestSpecial(String s) {

        List<String> list = new ArrayList<>();

        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }

            // ek complete special substring mil gaya
            if (count == 0) {

                String inner = s.substring(start + 1, i);

                String special =
                    "1" + makeLargestSpecial(inner) + "0";

                list.add(special);

                start = i + 1;
            }
        }

        // lexicographically largest pehle
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder ans = new StringBuilder();

        for (String x : list) {
            ans.append(x);
        }

        return ans.toString();
    }
}