class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        helper(res,new ArrayList<>(),s,0,1);
        return res;
    }
    public void helper(List<List<String>> res,List<String> ls,String s,int index,int end){
        if(index==s.length()){
            res.add(new ArrayList<>(ls));
            return;
        }
        if(s.length()<end)return;
        String check=s.substring(index,end);
        if(pallin(check)){
            ls.add(check);
            helper(res,ls,s,end,end+1);
            ls.remove(ls.size()-1);
        }
        helper(res,ls,s,index,end+1);

    }
    public boolean pallin(String check){
        int i=0,j=check.length()-1;
        while(i<j){
            if(check.charAt(i)==check.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}