class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{if(a[0]!=b[0])return a[0]-b[0];return b[1]-a[1];});
        int[] current=intervals[0];
        int ans=0;
        for(int i=1;i<intervals.length;i++){
            if(current[1]>intervals[i][0]){
                current[1]=Math.min(current[1],intervals[i][1]);
                ans++;
            }else{
                current=intervals[i];
            }
        }
        return ans;
    }
}