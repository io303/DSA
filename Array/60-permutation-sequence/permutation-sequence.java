class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        List<Integer> ls=new ArrayList<>();
       for(int i=1;i<=n;i++){
        ls.add(i);
       }
      int fact=1;
       for(int i=2;i<n;i++){
        fact*=i;
       }
       k--;

       while(true){
        int index=k/fact;

        sb.append(ls.get(index));
        ls.remove(index);
     
        if(ls.size()==0)break;
        k=k%fact;
        fact=fact/ls.size();
       }
       return sb.toString();
    }
}