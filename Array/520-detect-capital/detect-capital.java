class Solution {
    public boolean detectCapitalUse(String word) {
        int c1=0;
        int c2=0;
        for(char ch:word.toCharArray()){
            if(Character.isUpperCase(ch))c1++;
            if(Character.isLowerCase(ch))c2++;
        }
        if(Character.isUpperCase(word.charAt(0))&&c1==1)return true;
        if(c1==word.length()||c2==word.length())return true;
        return false;
    }
}