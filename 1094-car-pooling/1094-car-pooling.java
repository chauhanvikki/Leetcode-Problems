class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] road=new int[1001];
        for(int i=0;i<trips.length;i++){
            road[trips[i][1]]+=trips[i][0];
            road[trips[i][2]]-=trips[i][0];
        }
        int seat=0;
        for(int i=0;i<1001;i++){
            seat+=road[i];
            if(seat>capacity)return false;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna