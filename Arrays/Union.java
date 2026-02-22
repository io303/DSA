import java.util.*;
public class Union {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr1[]={1,2,3,3,4,5,6};
        int arr2[]={3,3,5,5,6,7,8};
        List<Integer> res=new ArrayList<>();
        help(arr1,arr2,res);
        System.out.println(res);
    }

    private static void help(int[] arr1, int[] arr2, List<Integer> res) {
        int m=arr1.length;
        int n=arr2.length;
        int i=0,j=0;

        while(i<m&&j<n){
            if(i>0&&arr1[i]==arr1[i-1]){
                i++;
                continue;
            }
            if(j>0&&arr2[j]==arr2[j-1]){
                j++;
                continue;
            }
            if(arr1[i]<arr2[j]){
                res.add(arr1[i]);
                i++;
            }else if(arr1[i]>arr2[j]){
                res.add(arr2[j]);
                j++;
            }else{
                res.add(arr1[i]);
                i++;
                j++;
            }

        }
        while(i<m){
            res.add(arr1[i]);
            i++;
        }
        while(j<n){
            res.add(arr2[j]);
            j++;
        }
        
    }

}
