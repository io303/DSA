

public class CountDigitLeteer {
  public static void main(String[] args) {
    String s="abc123d@e";
    int d=0,l=0,sp=0;
    for(char ch:s.toCharArray()){
        if(Character.isDigit(ch)){
            d++;
        }
        else if(Character.isLetter(ch)){
            l++;
        }
        else{
            sp++;
        }
    }
    System.out.println(d+" "+l+" "+sp);
  }  
}
