class Solution {
    public String[] shortestSubstrings(String[] arr) {
        Map<String,Integer> mp=new HashMap<>();

        for(String s:arr){
            HashSet<String> st=new HashSet<>();

            for(int i=0;i<s.length();i++){
                for(int j=i+1;j<=s.length();j++){
                    st.add(s.substring(i,j));
                }
            }
            for(String sub:st){
                mp.put(sub,mp.getOrDefault(sub,0)+1);
            }
        }
        String ans[]=new String[arr.length];
        for(int k=0;k<arr.length;k++){
            String s=arr[k];
            String best="";

            for(int i=0;i<s.length();i++){
                for(int j=i+1;j<=s.length();j++){
                    String sub=s.substring(i,j);

                    if(mp.get(sub)==1){
                        if(best.equals("")||sub.length()<best.length()||
                        (sub.length()==best.length() && sub.compareTo(best)<0)){
                            best=sub;
                        }
                    }
                }
            }
            ans[k]=best;
        }
        return ans;
    }
}