class Solution {
    public String makeSmallestPalindrome(String s) {
        int n=s.length();

        char ch[]=s.toCharArray();

        int i=0,j=n-1;

        while(i<j){
            int x=ch[i];
            int y=ch[j];

            char z=(char)Math.min(x,y);
            ch[i]=z;
            ch[j]=z;
            i++;
            j--;
             System.out.println(z);
        }
        System.out.println(Arrays.toString(ch));
        return new String(ch);
    }
}