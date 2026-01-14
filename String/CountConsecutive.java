

public class CountConsecutive {
    public static void main(String[] args) {
        String s="aabbbccc";
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
                if(count==2||count==3){
                    System.out.println("yes");
                    break;
                }
            }
            else{
                count=1;
            }
        }
    }
}
