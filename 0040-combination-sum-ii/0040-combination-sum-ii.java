class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        helper(res,new ArrayList<>(),candidates,target,0,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> ls,int[] candidates,int target,int index,int sum){
        if(target==sum){
            res.add(new ArrayList<>(ls));
            return;
        }
        if(target<sum)return;
        if(candidates.length==index){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i-1]==candidates[i])continue;
            if(sum+candidates[i]>target)break;
            ls.add(candidates[i]);
            helper(res,ls,candidates,target,i+1,sum+candidates[i]);
            ls.remove(ls.size()-1);
        }
    }
} 