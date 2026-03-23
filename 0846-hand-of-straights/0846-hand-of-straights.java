class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0)return false;
        Arrays.sort(hand);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<hand.length;i++){
            if(!hm.containsKey(hand[i])){
                hm.put(hand[i],1);
            }
            else{
                hm.put(hand[i],hm.getOrDefault(hand[i],0)+1);
            }
        }
        for(int num:hand){
            if(hm.get(num)==0)continue;
            for(int k=0;k<groupSize;k++){
                int curr=num+k;
                if(hm.getOrDefault(curr,0)==0){
                    return false;
                }
                hm.put(curr,hm.get(curr)-1);
            }
        }
        return true;
    }
}