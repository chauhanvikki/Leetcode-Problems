class Solution {
    public String minWindow(String s, String t) {
        int windowStart=0;
        int windowEnd=0;
        int start=-1;
        int N=s.length();
        int uniqueChar=0;
        int minLen=Integer.MAX_VALUE;
        HashMap<Character,Integer> freq=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        uniqueChar=freq.size();
        while(windowEnd<N){
            char ch=s.charAt(windowEnd);
            if(freq.containsKey(ch)){
                freq.put(ch,freq.getOrDefault(ch,0)-1);
                if(freq.get(ch)==0){
                    uniqueChar--;
                }
            }
            while(uniqueChar==0){
                ch=s.charAt(windowStart);
                int len=windowEnd-windowStart+1;
                if(minLen>len){
                    minLen=len;
                    start=windowStart;
                }
                if(freq.containsKey(ch)){
                    freq.put(ch,freq.getOrDefault(ch,0)+1);
                    if(freq.get(ch)>0){
                        uniqueChar++;
                    }
                }
                windowStart++;
            }
            windowEnd++;
        }
        if(start==-1){
            return "";
        }
        return s.substring(start,minLen+start);
    }
}