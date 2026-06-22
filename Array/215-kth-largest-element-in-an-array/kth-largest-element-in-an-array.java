class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p=new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            p.offer(num);
        }
        int i=0;
        while(i<k-1){
            p.poll();
            i++;
        }
        return p.poll();
    }
}