class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        int[][] arr=new int[tasks.length][3];

        for (int i = 0; i < n; i++) {
            arr[i][0]=tasks[i][0];
            arr[i][1]=tasks[i][1];
            arr[i][2]=i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

            if (a[1] != b[1])
                return a[1] - b[1];

            return a[2] - b[2];
        });

        long time = 0;
        int i = 0;
        int k = 0;

        int[] ans = new int[n];

        while(i<arr.length || !pq.isEmpty()){
            if(pq.isEmpty()){
                time=Math.max(time,arr[i][0]);
            }
            while(i<n && arr[i][0]<=time){
                pq.offer(arr[i]);
                i++;
            }
            int[] curr=pq.poll();
            ans[k++]=curr[2];
            time+=curr[1];
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna