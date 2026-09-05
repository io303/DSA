class Solution {
    public String fractionAddition(String expression) {

        String[] arr = expression.split("(?=[+-])");

        int num = 0;
        int den = 1;

        for (String s : arr) {

            String[] fraction = s.split("/");

            int currNum = Integer.parseInt(fraction[0]);
            int currDen = Integer.parseInt(fraction[1]);

            // a/b + c/d = (a*d + c*b) / (b*d)
            num = num * currDen + currNum * den;
            den = den * currDen;

            // reduce fraction
            int g = gcd(Math.abs(num), den);
            num /= g;
            den /= g;
        }

        return num + "/" + den;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}