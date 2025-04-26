class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        if(n<3){
            return new ArrayList<>();
        }
        HashSet<ArrayList<Integer>> result=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                ArrayList<Integer> ls=new ArrayList<>();
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    j++;
                    k--;
                    result.add(ls);
                }
                else if(sum<0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}