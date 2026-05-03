class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1,max=1;
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        while(max>min){
            int mid=min+(max-min)/2;
            if(canEatBanana(piles,mid,h)){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        return min;
    }
    public boolean canEatBanana(int[] piles,int k,int h){
        int hours=0;
        for(int pile : piles){
            hours+=Math.ceil((double)pile/k);
        }
        System.out.println(hours);
        return h>=hours;
    }
}