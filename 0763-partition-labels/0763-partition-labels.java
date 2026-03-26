class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] freq=new int[26];
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']=i;
        }
        int end=0,k=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,freq[s.charAt(i)-'a']);
            k++;
            if(end==i){
                ls.add(k);
                k=0;
            }
        }
        return ls;
    }
}