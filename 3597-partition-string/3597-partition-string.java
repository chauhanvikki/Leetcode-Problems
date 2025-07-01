class Solution {
    public List<String> partitionString(String s) {
        HashSet<String> hs=new HashSet<>();
        List<String> ls=new ArrayList<>();
        String st="";
        for(int i=0;i<s.length();i++){
            st+=s.charAt(i);
            if(!hs.contains(st)){
                ls.add(st);
                hs.add(st);
                st="";
            }
        }
        return ls;
    }
}