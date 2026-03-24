import java.util.*;
class Solution {
    public int minimumDifference(int[] arr) {
        int N = arr.length;
        int n = N/2;

        int total = 0;
        for(int a : arr) total += a;

        // step 1:- partition the array into two parts

        // step 2:- generate subset sum 2d arrays for each

        ArrayList<Integer>[] left_sum= new ArrayList[n+1]; 
        ArrayList<Integer>[] right_sum = new ArrayList[n+1];

        for(int i = 0; i <= n; i++){
            left_sum[i] = new ArrayList<>();
            right_sum[i] = new ArrayList<>();
        } 

        // using bitmask to generate all possible subsets for each of left and right subarray, each mask will generate a subset
        for(int mask = 0; mask < (1<<n); mask++){
            int l_sum = 0, r_sum = 0, ct = 0;

            for(int i = 0; i < n; i++){
                if((mask & (1 << i) )!= 0){
                    ct++;                                           // count of number of elems in the subset
                    l_sum += arr[n-i-1];
                    r_sum += arr[i+n];
                }
            }
            left_sum[ct].add(l_sum);
            right_sum[ct].add(r_sum);
        }

        // Step 3:- sort the right arrayLists
        // we know that for two subsets with sums s1 and s2, if any one (say s1), will be as close as possible to (total/2), then we will get min value of |s1-s2|
        // sort the right arraylists in right_sum array
        for(ArrayList<Integer> arrl : right_sum){
            Collections.sort(arrl);
        } 

        // Step 4:- find the min value of abs difference

        int abs_diff = Integer.MAX_VALUE;
        for(int ct = 0; ct <= n; ct++){
            for(int sum : left_sum[ct]){
                // number of elems to be taken from right part 
                int right_ct = n-ct;
                
                // sum of elems taken from right
                int r_sum = lower_bound(right_sum[right_ct], total/2 - sum);

                // total sum of the subset 
                int total_sum = sum + r_sum;

                abs_diff = Math.min(abs_diff, Math.abs(total - 2*total_sum));
            }
        }

        return abs_diff;


    }

    public int lower_bound(ArrayList<Integer> arrl, int num){

        int n = arrl.size();
        int l = 0, r = n -1;

        while(l <= r){

            int mid = (l+r)/2;

            if(arrl.get(mid) == num) return num;

            if(arrl.get(mid) < num){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        if(l != n){
            return arrl.get(l);
        }else{
            return arrl.get(n-1);
        }
    }
}