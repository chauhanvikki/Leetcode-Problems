class Solution {
    public void duplicateZeros(int[] arr) {
        int n=arr.length;
        int[] res=new int[n];
        int idx=0;
        for(int i=0;i<n && idx<n;i++){
            if(arr[i]==0){
                // res[idx]=arr[i];
                idx=idx+2;
            }
            else{
                res[idx]=arr[i];
                idx++;
            }
        }
        for(int k=0;k<n;k++){
                arr[k]=res[k];
            }
    }
}