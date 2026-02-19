class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int left=0,right=0;
        int ans=0;
        if(s.isEmpty())return 0;
        while(right<s.length()){
            if(right==s.length())break;
            if(!hs.contains(s.charAt(right))){
                hs.add(s.charAt(right));
                right++;
            }
            else{
                hs.remove(s.charAt(left));
                left++;
            }
            ans=Math.max(hs.size(),ans);
        }
        return ans;
    }
}