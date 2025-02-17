class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] n=new int[Math.min(nums1.length,nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k=0;
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                if(k==0 || n[k-1] !=nums1[i]){
                    n[k]=nums1[i];
                    k++;
                }
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return Arrays.copyOf(n,k);
    }
}