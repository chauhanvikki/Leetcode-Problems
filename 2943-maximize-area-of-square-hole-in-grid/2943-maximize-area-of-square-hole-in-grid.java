class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int max1=1,max2=1,cnt1=1,cnt2=1,i=0,j=0;
        while(i<hBars.length-1 || j<vBars.length-1){
            if(i<hBars.length-1){
                if(hBars[i+1]-hBars[i]==1){
                    cnt1++;
                }else{
                    max1=Math.max(max1,cnt1);
                    cnt1=1;
                }
                i++;
            }
            if(j<vBars.length-1){
                 if(vBars[j+1]-vBars[j]==1){
                    cnt2++;
                }else{
                    max2=Math.max(max2,cnt2);
                    cnt2=1;
                }
                j++;
            }
        }
        max1=Math.max(max1,cnt1);
        max2=Math.max(max2,cnt2);
        int side=Math.min(max1+1,max2+1);
        return side*side;
    }
}