class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea=0;
        double y=0;
        double maxi=-Double.MAX_VALUE;
        double mini=Double.MAX_VALUE;
        for(int[] square: squares){
            int len=square[2];
            totalArea += (double) len * len;
            mini=Math.min(mini,square[1]);
            maxi=Math.max(maxi,len+square[1]);
        }
        double target=totalArea/2;
        double low=mini,high=maxi;
        while(high - low > 1e-6){
            double mid=(low+high)/2;
            if(areaBelow(mid,squares)<target){
                low=mid;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
    public double areaBelow(double mid,int[][] squares){
        double area=0;
        for(int[] square:squares){
            double y=square[1], len=square[2];
            if(mid>=y+len){
                area += (double) len * len;

            }
            else if((mid>y) && (mid<y+len)){
                area+=len*(mid-y);
            }
        }
        return area;
    }
}