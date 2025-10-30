class Solution {
    class pt{
        long dist;
        int[] pts;
        pt(long dist,int[] pts){
            this.dist=dist;
            this.pts=pts;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<pt> pq=new PriorityQueue<>((a,b)->(int)(a.dist-b.dist));
        int[][] res=new int[k][2];
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            long d=(long)x*x+(long)y*y;
            pt p=new pt(d,points[i]);
            pq.offer(p);
        }
        for(int i=0;i<k;i++){
            res[i]=pq.peek().pts;
            pq.poll();
        }
        return res;
    }
}