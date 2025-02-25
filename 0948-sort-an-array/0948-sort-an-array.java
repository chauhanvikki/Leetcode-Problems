class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    public static int[] mergeSort(int nums[],int s,int e){
        int m=s+(e-s)/2;
        if(s==e){
            return new int[]{nums[s]};
        }
        int left[]=mergeSort(nums,s,m);
        int right[]=mergeSort(nums,m+1,e);
        return Merge(left,right);
    }
    public static int[] Merge(int[] first,int[] second){
        int i=0;
        int j=0;
        int k=0;
        int mix[]=new int[first.length+second.length];
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }
            else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
}