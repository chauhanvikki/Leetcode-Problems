class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;
        int max=0;
        for(int pile:piles){
            max=Math.max(pile,max);
        }
        while(min<max){
            int mid=min+(max-min)/2;
            if(canEatInTime(piles,h,mid)){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        return min;
    }
    public boolean canEatInTime(int[] piles,int h,int speed){
        int hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=(int)Math.ceil((double)piles[i]/speed);
        }
        return hours<=h;
    }
}