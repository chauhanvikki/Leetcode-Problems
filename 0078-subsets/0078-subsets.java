class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        helper(nums,new ArrayList<>(),res,0);
        return res;
    }
    public void helper(int[] nums,List<Integer> ls,List<List<Integer>> res,int index){
        res.add(new ArrayList<>(ls));
        for(int i=index;i<nums.length;i++){
            ls.add(nums[i]);
            helper(nums,ls,res,i+1);
            ls.remove(ls.size()-1);
        }
    }
}