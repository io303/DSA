public class Armstrong {
    public static void main(String[] args) {
        int end=1000;
         int num, lastDigit, digits, sum;
            for(int i=1;i<=end;i++){
                sum=0;
                num=i;
                digits=(int)(Math.log10(num))+1;

                while(num>0){
                    lastDigit=num%10;
                    sum+=Math.pow(lastDigit,digits);
                    num=num/10;
                }

                if(i==sum){
                    System.out.println(i);
                }
            }
       
    }
}
