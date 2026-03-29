class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result=new ArrayList<>();
        // int i=0;
        // int n=intervals.length;
        // while(i<n){
        //     if(i==n-1)break;
        //     while(intervals[i][1]<intervals[i+1][0]){
        //         result.add(intervals[i]);
        //         i++;
        //     }
        //     int[] arr=new int[2];
        //     arr[0]=intervals[i][0];
        //     arr[1]=intervals[i][1];
        //     while(arr[1]>=intervals[i+1][0]){
        //         arr[1]=Math.max(arr[1],intervals[i+1][1]);
        //         arr[0]=Math.min(arr[0],intervals[i+1][0]);
        //         i++;
        //     }
        //     result.add(arr);
        // }
        // while(i<n){
        //     result.add(intervals[i]);
        //     i++;
        // }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] current=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(current[1]>=intervals[i][0]){
                current[1]=Math.max(current[1],intervals[i][1]);
            }
            else{
                result.add(current);
                current=intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}