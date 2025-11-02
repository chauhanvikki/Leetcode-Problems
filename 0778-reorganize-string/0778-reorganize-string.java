class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(hm.entrySet());
        Map.Entry<Character,Integer> prev=null;
        StringBuilder result=new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> current=pq.poll();
            result.append(current.getKey());
            current.setValue(current.getValue()-1);
            if(prev!=null && prev.getValue()>0){
                pq.offer(prev);
            }
            prev=current;
        }
        return (s.length()==result.length())?result.toString():"";
    }
}