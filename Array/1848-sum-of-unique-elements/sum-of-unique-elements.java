class Solution {
    public int sumOfUnique(int[] nums) {
    Map<Integer,Integer> mp=new HashMap<>();
    for(int a:nums){
        mp.put(a,mp.getOrDefault(a,0)+1);
    }
    int sum=0;
    for(Map.Entry<Integer,Integer> e:mp.entrySet()){
        if(e.getValue()==1){
            sum+=e.getKey();
        }
    }
    return sum;
    }
}