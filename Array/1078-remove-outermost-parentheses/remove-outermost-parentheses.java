class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int sum = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (sum > 0) res.append(c); // skip first '(' of a primitive
                sum++;
            } else {
                sum--;
                if (sum > 0) res.append(c); // skip last ')' of a primitive
            }
        }
        return res.toString();
    }
}

