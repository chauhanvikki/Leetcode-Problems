class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        helper(res,new ArrayList<>(), candidates,target,0,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> ls,int[] candidates,int target,int sum,int index){
        if(target==sum){
            res.add(new ArrayList<>(ls));
            return;
        }
        if(sum>target)return;
        if(index==candidates.length){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            ls.add(candidates[i]);
            helper(res,ls,candidates,target,sum+candidates[i],i);
            ls.remove(ls.size()-1);
        }
    }
}   