class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long c=0;
        long ans=0;
        while(n!=0){
            if(n%10!=0){
                long rem=n%10;
                ans+=rem;
                sum=sum*10+rem;
                n=n/10;
            }else{
                
                n=n/10;
            }
        }
        
         while(sum!=0){
           
                long rem=sum%10;
                
                c=c*10+rem;
                sum=sum/10;
            }
        return c*ans;
    }
}