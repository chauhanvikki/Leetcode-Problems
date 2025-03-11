class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;int j=0;
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            while(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(j));
                j++;
            }
                hs.add(s.charAt(i));
                max=Math.max(max,hs.size());
        }
        return max;
    }
}