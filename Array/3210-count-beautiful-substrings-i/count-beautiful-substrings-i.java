class Solution {

    public int beautifulSubstrings(String s, int k) {

        int n = s.length();
        int count = 0;

        for(int i = 0; i < n; i++) {

            int vowels = 0;
            int consonants = 0;

            for(int j = i; j < n; j++) {

                char ch = s.charAt(j);

                if(isVowel(ch)) {
                    vowels++;
                } else {
                    consonants++;
                }

                // beautiful substring
                if(vowels == consonants &&
                   (vowels * consonants) % k == 0) {

                    count++;
                }
            }
        }

        return count;
    }

    public boolean isVowel(char ch) {

        return ch=='a' || ch=='e' ||
               ch=='i' || ch=='o' ||
               ch=='u';
    }

   
}