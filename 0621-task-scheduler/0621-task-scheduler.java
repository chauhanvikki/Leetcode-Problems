class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int[26];
        // Count the freq
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        // create a Priorityqueue to prioritize the max freq
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:freq){
            if(num>0)pq.offer(num);
        }
        int totalTime=0;
        while(!pq.isEmpty()){
            int time=0;
            List<Integer> ls=new ArrayList<>();

            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    int current=pq.poll();
                    if(current-1>0)ls.add(current-1);
                    time++;
                }
            }
            for(int remaining:ls)pq.add(remaining);
            totalTime+=(pq.isEmpty())?time:n+1;  //if in last pqEmpty then time++
        }
        return totalTime;
    }
}