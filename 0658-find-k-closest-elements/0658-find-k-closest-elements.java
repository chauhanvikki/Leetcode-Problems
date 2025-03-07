class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0;
        int r=arr.length-k;
        while(l<r){
            int m=l+(r-l)/2;
            if(x-arr[m]<=arr[m+k]-x){
                r=m;
            }
            else{
                l=m+1;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=l;i<k+l;i++){
            res.add(arr[i]);
        }
        return res;
    }
}