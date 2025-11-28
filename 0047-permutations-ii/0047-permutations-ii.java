class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        boolean used[]=new boolean[nums.length];
        helper(nums,used,res,new ArrayList<>());
        return res;
    }
    public void helper(int[] nums,boolean used[],List<List<Integer>> res,List<Integer> ls){
        if(nums.length==ls.size()){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            if(i>0 && nums[i-1]==nums[i] && !used[i-1])continue;
            ls.add(nums[i]);
            used[i]=true;
            helper(nums,used,res,ls);
            ls.remove(ls.size()-1);
            used[i]=false;
        }
    } 
}