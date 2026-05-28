class Solution {
    public String sortVowels(String s) {
        char chi[]=new char[s.length()];
        int j=0;
        for(int i=0;i<s.length();i++){
            if(vowel(s.charAt(i))){
                chi[j]=s.charAt(i);
                j++;
            }
        }
        Arrays.sort(chi);
       StringBuilder sb=new StringBuilder();
       int k=0;
       while(k<chi.length&&!Character.isLetter(chi[k])){
        k++;
       }
       for(int i=0;i<s.length();i++){
        if(vowel(s.charAt(i))){
            sb.append(chi[k++]);
        }
        else{
            sb.append(s.charAt(i));
        }
       }
       
       return sb.toString();
    }
    boolean vowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U';
    }
}