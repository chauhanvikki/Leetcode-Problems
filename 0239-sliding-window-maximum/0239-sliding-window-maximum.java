class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int result[]=new int[n-k+1];
        int j=0;
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollFirst();
            }

            dq.offerLast(i);
            if(i>=k-1){
                result[j]=nums[dq.peekFirst()];
                j++;
            }
        }
        return result;
    }
}