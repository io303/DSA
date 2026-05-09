class Solution {
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        int n=chars.length;
        while(i<n){
            int c=0;
            char init=chars[i];

            while(i<n&&chars[i]==init){
                c++;
                i++;
            }
            sb.append(init);
            if(c>1){
                sb.append(c);
            }
        }
         for (int j = 0; j < sb.length(); j++) {
            chars[j] = sb.charAt(j);
        }
        return sb.length();
    }
}