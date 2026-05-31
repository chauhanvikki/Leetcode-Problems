class Solution {
    public boolean asteroidsDestroyed(int weight, int[] arr) {
        int i=0;
        int j=arr.length-1;
        Arrays.sort(arr);
        long mass=weight;
        while(i<=j){
            if(arr[j]<=mass){
                mass+=arr[j];
                j--;
            }
            else if(arr[i]<=mass){
                mass+=arr[i];
                i++;
            }
            else{
                return false;
            }
        }
        return true;
    }
}