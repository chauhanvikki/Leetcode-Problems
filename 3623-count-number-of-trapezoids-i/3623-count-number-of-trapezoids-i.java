class Solution {
    int mod=1000000007;
    public int countTrapezoids(int[][] points) {
        HashMap<Integer,Long> hm=new HashMap<>();
        for(int p[] : points){
            int y=p[1];
            hm.put(y,hm.getOrDefault(y,0L)+1);
        }
        List<Long> ls=new ArrayList<>();
        for(Map.Entry<Integer,Long> nm : hm.entrySet()){
            long val=nm.getValue();
            long newVal=(val*(val-1)/2)%mod;
            ls.add(newVal);
        }
        long ans=0;
        long sum=0;
        for(long val:ls){
            ans=(ans+(sum*val)%mod)%mod;
            sum=(sum+val)%mod;
        }
        return (int)ans;
    }
}