class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int freq[]=new int[n*n+1];
        int res[]=new int[2];

        for(int arr[]:grid){
            for(int val:arr){
                freq[val]++;
            }
        }
        for(int i=1;i<=n*n;i++){
            if(freq[i]==2){
                res[0]=i;
            }
            if(freq[i]==0){
                res[1]=i;
            }
        }
        return res;
    }
}