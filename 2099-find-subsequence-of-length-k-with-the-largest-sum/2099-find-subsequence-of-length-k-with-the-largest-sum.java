class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n=nums.length;
        int[][] indexVal=new int[n][2];
        for(int i=0;i<n;i++){
            indexVal[i][0]=nums[i];
            indexVal[i][1]=i;
        }

        Arrays.sort(indexVal,(a,b)->b[0]-a[0]);

        int[][] topK=Arrays.copyOfRange(indexVal,0,k);

        Arrays.sort(topK,(a,b)->a[1]-b[1]);

        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=topK[i][0];
        }
        return ans;
    }
}