class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        int ans[]=new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){       
                ans[i]=-1;
                    }
            else{
                ans[i]=st.peek();
            }
            st.push(nums2[i]);
        }
        return next(ans,hm,nums1,nums2);
    }
    public static int[] next(int[] ans,HashMap<Integer,Integer> hm,int[] nums1,int[] nums2){
        for(int i=0;i<nums2.length;i++){
            hm.put(nums2[i],ans[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=hm.get(nums1[i]);
        }
        return nums1;
    }
}