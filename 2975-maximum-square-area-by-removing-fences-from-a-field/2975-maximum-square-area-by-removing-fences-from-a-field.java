class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h=new int[hFences.length+2];
        int[] v=new int[vFences.length+2];
        h[0]=1;
        h[h.length - 1]=m;
        v[0]=1;
        v[v.length-1]=n;
        int mod=1000000007;
        HashSet<Integer> height=new HashSet<>();
        for(int i=0;i<hFences.length;i++){
            h[i+1]=hFences[i];
        }
        for(int i=0;i<vFences.length;i++){
            v[i+1]=vFences[i];
        }
        Arrays.sort(h);
        Arrays.sort(v);
        for(int i=0;i<h.length;i++){
            for(int j=i+1;j<h.length;j++){
                height.add(h[j]-h[i]);
            }
        }
        long maxi=0;
        for(int i=0;i<v.length;i++){
            for(int j=i+1;j<v.length;j++){
                int wide=v[j]-v[i];
                if(height.contains(wide)){
                    maxi=Math.max(wide,maxi);
                }
            }
        }
        if(maxi==0)return -1;
        return (int)((maxi*maxi)%mod);
    }
}