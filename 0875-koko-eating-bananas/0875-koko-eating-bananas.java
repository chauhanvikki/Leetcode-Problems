class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;
        int max=0;
        for(int pile:piles){
            max=Math.max(pile,max);
        }
        int mid=0;
        while(max>min){
            mid=min+(max-min)/2;
            if(canEatBanana(piles,h,mid)){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        return min;
    }
    public boolean canEatBanana(int[] piles,int h,int speed){
        int hours=0;
        for(int pile:piles){
            hours+=(int)(Math.ceil((double)pile/speed));
        }
        return hours<=h;
    }
}