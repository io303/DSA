import java.util.*;

public class MergeSorted2array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int arr1[]=new int[n1];
        
        for(int i=0;i<n1;i++){
            arr1[i]=sc.nextInt();
        }
      int n2=sc.nextInt();
        int arr2[]=new int[n2];
         for(int i=0;i<n2;i++){
            arr2[i]=sc.nextInt();
        }
        int n=n1+n2;
        int arr[]=new int[n];
        int index1=0;
        int index2=0;
        int mergeindex=0;
        while(index1<n1&&index2<n2){
            if(arr1[index1]<arr2[index2]){
                arr[mergeindex]=arr1[index1];
                index1++;
                    }
                    else{
                        arr[mergeindex]=arr2[index2];
                        index2++;
                    }
                    mergeindex++;

    }
    while(index1<n1){
        arr[mergeindex]=arr1[index1];
        index1++;
        mergeindex++;
    }
    while(index2<n2){
        arr[mergeindex]=arr2[index2];
        index2++;
        mergeindex++;
    }
    for (int idx = 0; idx < arr.length; idx++) {
       System.out.println(arr[idx]);
        
    }
}


}
