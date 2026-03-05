public class Kadane {
    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        int currSum=arr[0];
        int maxsum=arr[0];
        int s=0,ansS=0,ansE=0;
        int n=arr.length;

        for(int i=1;i<n;i++){
            if(arr[i]>currSum+arr[i]){
                currSum=arr[i];
                s=i;
            }else{
                currSum+=arr[i];
            }
            if(currSum>maxsum){
               maxsum=currSum;
               ansS=s;
               ansE=i; 
            }
        }
            for(int i=ansS;i<=ansE;i++){
                System.out.print(arr[i]+" ");
            }

    }
}
