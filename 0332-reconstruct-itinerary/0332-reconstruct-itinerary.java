class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue> hm=new HashMap<>();
        for(int i=0;i<tickets.size();i++){
            String key=tickets.get(i).get(0);
            String value=tickets.get(i).get(1);
            if(!hm.containsKey(key)){
                PriorityQueue<String> pq=new PriorityQueue<>();
                hm.put(key,pq);
            }
            hm.get(key).add(value);
        }
        LinkedList<String> res=new LinkedList<>();
        dfs("JFK",hm,res);
        return res;
    }
    public void dfs(String dep,HashMap<String,PriorityQueue> hm,LinkedList<String> res){
        PriorityQueue<String> pq=hm.get(dep);
        while(pq!=null && !pq.isEmpty()){
            dfs(pq.poll(),hm,res);
        }
        res.addFirst(dep);
    }
}