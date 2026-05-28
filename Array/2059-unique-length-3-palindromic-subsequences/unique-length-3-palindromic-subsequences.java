class Solution {
    public int countPalindromicSubsequence(String s) {
        int c=0;
        for(char ch='a';ch<='z';ch++){
            int f=s.indexOf(ch);
            int l=s.lastIndexOf(ch);
            

            if(f!=-1&&f<l){
                HashSet<Character> st=new HashSet<>();
                for(int i=f+1;i<l;i++){
                    st.add(s.charAt(i));

                }
                c+=st.size();
            }
        }
        return c;
    }
}