class Solution {
    public int countSubstrings(String s) {
        if(s.length()==1)return 1;
        int ans=0;
        for(int i=1;i<s.length();i++){
            int low=i,high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==s.length()){
                    ans++;
                    break;
                }
            }
            low=i-1;
            high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==s.length()){
                    ans++;
                    break;
                }
            }
            ans=Math.max(ans,high-low+1);
        }
        return ans;
    }
}