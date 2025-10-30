class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:stones){
            pq.add(num);
        }
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            if(first>second){
                pq.add(first-second);
            }
            else if(second>first){
                pq.add(second-first);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.peek();
    }
}