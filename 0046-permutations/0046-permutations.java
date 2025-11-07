class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean used[]=new boolean[nums.length];
        helper(res,new ArrayList<>(),nums,used);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> ls,int[] nums,boolean[] used){
        if(nums.length==ls.size()){
            res.add(new ArrayList(ls));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            used[i]=true;
            ls.add(nums[i]);
            helper(res,ls,nums,used);
            ls.remove(ls.size()-1);
            used[i]= false;
            }
        }
}