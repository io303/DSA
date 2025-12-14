public class Perfect {
    public static void main(String[] args) {
        int n=6;
        int sum=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        if(n==sum){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
