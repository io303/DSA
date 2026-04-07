class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
    List<Integer> curr=new ArrayList<>();
    backtrack(curr,0,nums);
    return res;
    }
    void backtrack(List<Integer> curr,int i,int nums[]){
        if(i==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        backtrack(curr,i+1,nums);
        curr.remove(curr.size()-1);
        backtrack(curr,i+1,nums);
    }
}