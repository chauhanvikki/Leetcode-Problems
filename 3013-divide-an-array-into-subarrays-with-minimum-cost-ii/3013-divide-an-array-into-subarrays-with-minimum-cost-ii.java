// class Solution {
//     public long minimumCost(int[] nums, int k, int dist) {
//         int n=nums.length;
//         TreeSet<Integer> sel=new TreeSet<>((a,b)->{
//             if(nums[a]==nums[b])return a-b;
//             return nums[a]-nums[b];
//         });
//         TreeSet<Integer> rem=new TreeSet<>((a,b)->{
//             if(nums[a]==nums[b])return a-b;
//             return nums[a]-nums[b];
//         });
//         k=k-1;
//         long currSum=0;
//         long ans=Long.MAX_VALUE;
//         int last=Math.min(dist+1,n-1);
//         for(int i=0;i<=last;i++){
//             currSum+=nums[i];
//             sel.add(i);
//         }
//         while(sel.size()>k-1){
//             int idx=sel.pollLast();
//             currSum=currSum-nums[idx];
//             rem.add(idx);
//         }
//         ans=currSum;
//         for(int r=dist+2,l=1;r<n;r++,l++){
//             rem.add(r);
//             if(sel.contains(l)){
//                 sel.remove(l);
//                 currSum-=nums[l];
//                 int smallest=rem.pollFirst();
//                 sel.add(smallest);
//                 currSum+=nums[smallest];
//             }else{
//                 rem.remove(l);
//                 if(!sel.isEmpty() && !rem.isEmpty() && nums[sel.last()]>nums[rem.first()]){
//                     int big=sel.pollLast();
//                     currSum-=nums[big];
//                     rem.add(big);
//                     int small=rem.pollFirst();
//                     sel.add(small);
//                     currSum+=nums[small];
//                 }
//             }
//             ans=Math.min(ans,currSum);
//         }
//         return nums[0]+ans;
//     }
// }

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        TreeSet<Integer> currset = new TreeSet<>((a,b)-> nums[a]!=nums[b] ? nums[a]-nums[b] : a-b);
        TreeSet<Integer> futset = new TreeSet<>((a,b)-> nums[a]!=nums[b] ? nums[a]-nums[b] : a-b);
        long cost = Long.MAX_VALUE;
        int n = nums.length;
        long currsum = 0l; 

        for(int i=1; i<=dist+1; i++) {
            currset.add(i);
            currsum += nums[i];
        }
        while(currset.size() > k-1) {
            int ind = currset.pollLast();
            currsum -= nums[ind];
            futset.add(ind);
        }
        cost = currsum;
        for(int i=1; i < n-1-dist; i++) {
            int rightInd = i+dist+1;
            int leftInd = i;
            
            if(currset.contains(leftInd)) {
                currsum -= nums[leftInd];
                currset.remove(leftInd);
                currsum += nums[rightInd];
                currset.add(rightInd);
            }
            else {
                futset.remove(leftInd);
                futset.add(rightInd);
            }

          
            if(futset.size() > 0) {
                int minF = futset.first();
                int maxC = currset.last();
                if(nums[minF] < nums[maxC]) {
                    currsum -= nums[maxC];
                    currset.remove(maxC);
                    currset.add(minF);
                    currsum += nums[minF];
                    futset.remove(minF);
                    futset.add(maxC);
                }
            }
            cost = Math.min(cost, currsum);
        }
        return cost + nums[0];
    }
}