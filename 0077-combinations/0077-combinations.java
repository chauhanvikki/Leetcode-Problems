class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        solve(n,k,res,ls,1);
        return res;
    }
    public void solve(int n,int k,List<List<Integer>> res,List<Integer> ls,int num){
        if(ls.size()==k){
            res.add(new ArrayList<>(ls));
            return;
        }
        if(num>n){
            return;
        }
        ls.add(num);
        solve(n,k,res,ls,num+1);
        ls.remove(ls.size()-1);
        solve(n,k,res,ls,num+1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna