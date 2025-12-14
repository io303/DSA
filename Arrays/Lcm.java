public class Lcm {
   public static void main(String[] args) {
    int a=3,b=4;
    while(b!=0){
        int temp=b;
        b=a%b;
        a=temp;
    }
    int hcf=a;
    System.out.println(a);
    System.out.println((3*4)/hcf);
   } 
}
