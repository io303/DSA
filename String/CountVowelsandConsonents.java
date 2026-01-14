

public class CountVowelsandConsonents {
    public static void main(String[] args) {
        String s="abdeswei@ourt";
        int v=0,c=0;
        for(char ch:s.toCharArray()){
            if(ch>='a'&&ch<='z'){
                if("aeiou".indexOf(ch)!=-1){
                    v++;
                }
                else{
                    c++;
                }
            }
        }
        System.out.println(v+" "+c);
    }
}
