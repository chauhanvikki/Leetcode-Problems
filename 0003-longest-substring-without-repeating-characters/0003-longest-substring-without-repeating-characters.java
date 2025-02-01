class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        if(s.isEmpty()){
            return 0;
        }
        int i=0;
        int m=0;
        // hs.add(s.charAt(0));
            for(int j=i;j<s.length();j++){
            while(hs.contains(s.charAt(j))){
                hs.remove(s.charAt(i));
                i++;
            }
                hs.add(s.charAt(j));
                m=Math.max(m,hs.size());
            }
        
        return m;
}
}