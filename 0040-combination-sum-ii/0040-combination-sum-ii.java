class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        helper(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> ls, int[] nums,int target,int start){
            if(target==0){
                res.add(new ArrayList<>(ls));
                return;
            }
            else if(target<0)return;
            for(int i=start;i<nums.length;i++){
                if(i>start && nums[i]==nums[i-1])continue;
                ls.add(nums[i]);
                helper(res,ls,nums,target-nums[i],i+1);
                ls.remove(ls.size()-1);
            }
    }
}