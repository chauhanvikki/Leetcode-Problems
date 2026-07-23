class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=capital[i];
            arr[i][1]=profits[i];
        }
        int ans=0;
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int i=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        ans+=w;
        while( k>0){
            while(i<n && ans>=arr[i][0]){
                System.out.println("capital="+arr[i][0]);
                pq.offer(arr[i][1]);
                System.out.println("Pq peek = "+ pq.peek());
                i++;
            }
            if(!pq.isEmpty())ans+=pq.poll();
            k=k-1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna