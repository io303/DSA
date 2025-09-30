import java.util.*;

public class DivideTwoIntegers1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = divide(a, b);
            System.out.println(c );
        }
    }

    static int divide(int a, int b) {
        // Special cases
        if (b == 0) return Integer.MAX_VALUE; 
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;

        // Determine sign
        boolean sign = (a >= 0) == (b >= 0);

        // Work with positive longs
        long n = Math.abs((long) a);
        long d = Math.abs((long) b);
        long q = 0;

        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
            q += 1L << cnt;
            n -= d << cnt;
        }

        // Apply sign
        int result = (int) (sign ? q : -q);
        return result;
    }
}

