class Solution {
    public boolean halvesAreAlike(String s) {
        int c1=0,c2=0;
        for(int i=0;i<s.length()/2;i++){
            if(vowel(Character.toLowerCase(s.charAt(i))))c1++;
        }
         for(int i=s.length()/2;i<s.length();i++){
            if(vowel(Character.toLowerCase(s.charAt(i))))c2++;
        }
        return c1==c2;
    }
    boolean vowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') return true;
        return false;
    }
}