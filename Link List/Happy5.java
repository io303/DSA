import java.util.Scanner;

public class Happy5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(happy(n));
    }

    private static boolean  happy(int n) {
        int f=n;
        int s=n;
        do { 
            f=square(f);
            s=square(square(s));
        } while (f!=s);
        if(f==1){
            return true;
        }
        return false;
    }

    private static int square(int n) {
        int res=0;
        while(n>0){
            int rem=n%10;
            res+=rem*rem;
            n=n/10;
        }
        return res;
    }
}
