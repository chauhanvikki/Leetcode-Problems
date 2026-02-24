class Solution {
    public int countSubstrings(String s) {
        if(s.length()==1)return 1;
        int ans=0;
        for(int i=0;i<s.length();i++){
            int low=i,high=i;
            while(low!=-1 && high!=s.length() && s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                ans++;
            }
            low=i-1;
            high=i;
            while(low!=-1 && high!=s.length() && s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                ans++;
            }
        }
        return ans;
    }
}