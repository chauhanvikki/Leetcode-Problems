class Solution {
    public int characterReplacement(String s, int k) {
        int freq[]=new int[26];
        int maxWindow=0;
        int windowlen=0;
        int left=0;
        int maxFreq=0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(right)-'A']);
            windowlen=right-left+1;
            if(windowlen-maxFreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            windowlen=right-left+1;
            maxWindow=Math.max(windowlen,maxWindow);
        }
        return maxWindow;
    }
}