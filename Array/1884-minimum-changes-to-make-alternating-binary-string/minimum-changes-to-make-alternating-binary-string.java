import java.util.*;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int c1 = 0; 
        int c2 = 0; 

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                if (s.charAt(i) != '0') c1++;
                if (s.charAt(i) != '1') c2++;
            } 
            else {
                if (s.charAt(i) != '1') c1++;
                if (s.charAt(i) != '0') c2++;
            }

        }

        return Math.min(c1, c2);
    }

    
}