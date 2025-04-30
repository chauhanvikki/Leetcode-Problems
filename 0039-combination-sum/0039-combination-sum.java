class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        helper(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> ls,int[] nums,int target,int start){
        if(target<0) return;
        else if(target==0) res.add(new ArrayList<>(ls));
        else{
            for(int i=start;i<nums.length;i++){
                ls.add(nums[i]);
                helper(res,ls,nums,target-nums[i],i);
                ls.remove(ls.size()-1);
            }
        }
    }
}