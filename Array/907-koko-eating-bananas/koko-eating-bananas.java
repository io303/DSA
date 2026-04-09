class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=get(piles);
        while(l<r){
           int mid=l+(r-l)/2;
            if(eat(mid,h,piles)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    int get(int piles[]){
        int res=0;
        for(int n:piles){
            res=Math.max(res,n);
        }
        return res;
    }
    boolean eat(int k,int h,int piles[]){
        int t=0;
        for(int n:piles){
            t+=(n+k-1)/k;
        }
        return t<=h;
    }
}