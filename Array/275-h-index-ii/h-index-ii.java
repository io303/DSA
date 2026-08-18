class Solution {
    
    public int hIndex(int[] citations) {
        int l=0,h=citations.length;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(help(mid,citations)){
                ans=Math.max(ans,mid);
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
    boolean help(int k,int citations[]){
        int c=0;

        for(int a:citations){
            if(a>=k)c++;
        }
        return c>=k;
    }
}