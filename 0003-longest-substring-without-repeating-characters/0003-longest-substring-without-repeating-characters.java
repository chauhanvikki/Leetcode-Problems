class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> h=new HashSet<>();
        int i=0;
        int m=0;
        int n=s.length();
        for(int j=i;j<n;j++){
            while(h.contains(s.charAt(j))){
                // h.clear();
                h.remove(s.charAt(i));
                i++;
            }
            // if(!h.contains(s.charAt(j))){
            h.add(s.charAt(j));
            m=Math.max(m,h.size());
            // }
        }
        return m;
    }
}