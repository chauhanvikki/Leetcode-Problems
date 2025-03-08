class Solution {
    public void duplicateZeros(int[] arr) {
        int n=arr.length;
        int[] res=new int[n];
        int idx=0;
        // int j=0;
        // while(i<n && j<n){
        //     if(arr[i]==0 && j+1<n){
        //         res[j]=arr[i];
        //         res[j+1]=arr[i];
        //         j=j+2;
        //         i++;
        //     }
        //     else{
        //         res[j]=arr[i];
        //         j++;
        //         i++;
        //     }
        // }
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
        System.out.println(Arrays.toString(arr));
    }
}