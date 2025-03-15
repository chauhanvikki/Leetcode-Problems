class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        parenth("",0,0,n,ans);
        return ans;
    }
    private void parenth(String curr,int open,int close,int n,List<String> ans){
        if(curr.length()==2*n){
            ans.add(curr);
            return;
        }
        if(open<n){
            parenth(curr+"(",open+1,close,n,ans);
        }
        if(close<open){
            parenth(curr+")",open,close+1,n,ans);
        }
        // System.out.print(ans);
    }
}