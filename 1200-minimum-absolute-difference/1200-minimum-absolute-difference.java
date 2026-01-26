class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            mini=Math.min(mini,arr[i]-arr[i-1]);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==mini){
                List<Integer> ls=new ArrayList<>();
                ls.add(arr[i-1]);
                ls.add(arr[i]);
                res.add(ls);
            }
        }
        return res;
    }
}