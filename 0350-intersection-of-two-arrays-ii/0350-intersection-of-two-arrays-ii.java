class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] n=new int[Math.min(nums1.length, nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int N=nums1.length;
        int M=nums2.length;
        int i=0;
        int j=0;
        int k=0;
        while(i<N && j<M){
            if(nums1[i]==nums2[j]){
                    n[k]=nums1[i];
                    k++;
                // }
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