class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int y=nums.length-1;
            int x=i+1;
            if(i>0 && nums[i]==nums[i-1])continue;
            while(x<y){
                List<Integer> ls=new ArrayList<>();
                int sum=nums[i]+nums[x]+nums[y];
                if(sum==0){
                    ls.add(nums[i]);
                    ls.add(nums[x]);
                    ls.add(nums[y]);
                    res.add(ls);
                    while(x<y && nums[x]==nums[x+1]){
                        x++;
                    }
                    while(y>x && nums[y]==nums[y-1]){
                        y--;
                    }
                }
                if(sum<0){
                    x++;
                }
               else{
                y--;
               }
            }
        }
        return new ArrayList<>(res);
    }
}