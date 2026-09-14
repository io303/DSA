class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int nse[]=new int[n];

        Stack<Integer>  st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&prices[st.peek()]>prices[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=prices[n-1]+1;
            }else{
                nse[i]=prices[st.peek()];
            }
            st.push(i);
        }
   int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(nse[i]<=prices[i]){
                ans[i]=prices[i]-nse[i];
            }else{
                ans[i]=prices[i];
            }
        }
        return ans;
    }
}