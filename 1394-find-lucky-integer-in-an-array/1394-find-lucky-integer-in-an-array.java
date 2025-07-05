class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int maxi=0;
        for(int num:arr){
            if(hm.containsKey(num)){
                hm.put(num,hm.get(num)+1);
            }
            else{
                hm.put(num,1);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==hm.get(arr[i])){
                maxi=Math.max(maxi,arr[i]);
            }
            else if(i==arr.length-1){
                if(maxi==0){
                    return -1;
                }
            }
        }
        return maxi;
    }
}