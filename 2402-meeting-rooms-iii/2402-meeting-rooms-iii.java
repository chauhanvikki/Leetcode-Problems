class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        long endTimes[]=new long[n];
        int meetingCount[]=new int[n];
        int ans=0;
        for(int meeting[] : meetings){
            int start=meeting[0];
            int end=meeting[1];
            int duration=end-start;
            int free=-1;
            for(int i=0;i<n;i++){
                if(start>=endTimes[i]){
                    free=i;
                    break;
                }
            }
            if(free!=-1){
                endTimes[free]=start+duration;
                meetingCount[free]++;
            }
            else{
                long time=endTimes[0];
                int earlyRoom=0;
                int[] meetingEnd=new int[n];
                for(int i=1;i<n;i++){
                    if(time>endTimes[i]){
                        time=endTimes[i];
                        earlyRoom=i;
                    }
                }
                endTimes[earlyRoom]=time+duration;
                meetingCount[earlyRoom]++;
            }
        }
        int count=meetingCount[0];
        for(int i=1;i<n;i++){
            if(count<meetingCount[i]){
                ans=i;
                count=meetingCount[i];
            }
        }
        return ans;
    }
}