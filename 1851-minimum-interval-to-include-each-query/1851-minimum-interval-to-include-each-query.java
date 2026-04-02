class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int i=0;i<intervals.length;i++){
        //     int start=intervals[i][0];
        //     int end=intervals[i][1];
        //     for(int j=start;j<=end;j++){
        //         if(hm.containsKey(j)){
        //             int val=Math.min(hm.get(j),end-start+1);
        //             hm.remove(j);
        //             hm.put(j,val);
        //         }
        //         else{
        //             hm.put(j,end-start+1);
        //         }
        //     }
        // }
        // for(int i=0;i<queries.length;i++){
        //     if(hm.containsKey(queries[i])){
        //         queries[i]=hm.get(queries[i]);
        //     }
        //     else{
        //         queries[i]=-1;
        //     }
        // }
        // return queries;
        TreeMap<Integer,Integer> pq=new TreeMap<>();
        HashMap<Integer,Integer> ans=new HashMap<>();
        int[] originalQuery=queries.clone();
        Arrays.sort(queries);
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int j=0;
        for(int i=0;i<queries.length;i++){
            while(intervals.length>j && intervals[j][0]<=queries[i]){
                pq.put(intervals[j][1]-intervals[j][0]+1,intervals[j][1]);
                j++;
            }

            while(!pq.isEmpty() && pq.firstEntry().getValue()<queries[i]){
                pq.pollFirstEntry();
            }

            if(pq.isEmpty())ans.put(queries[i],-1);
            else ans.put(queries[i],pq.firstKey());
        }
        for(int i=0;i<queries.length;i++){
            originalQuery[i]=ans.get(originalQuery[i]);
        }
        return originalQuery;
    }
}