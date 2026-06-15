/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peaki=peak(mountainArr,0,mountainArr.length()-1);
        int l=left(target,mountainArr,0,peaki);
        int r=right(target,mountainArr,peaki,mountainArr.length()-1);
        if(l!=-1)return l;
        if(r!=-1)return r;
        return -1;
    }
    public int right(int target,MountainArray mount,int low,int high){
        int peaki=low;
        while(low<=high){
            int mid=low+(high-low)/2;
            int now=mount.get(mid);
            if(target==now)return mid;
            else if(target<now){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    public int left(int target,MountainArray mount,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            int now=mount.get(mid);
            if(target==now)return mid;
            else if(target<now){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public int peak(MountainArray mount,int low,int high){
        if(low==high)return low;
        int mid=low+(high-low)/2;
        int now=mount.get(mid);
        if(now<mount.get(mid+1)){
            return peak(mount,mid+1,high);
        }
        return peak(mount,low,mid);
    }
}