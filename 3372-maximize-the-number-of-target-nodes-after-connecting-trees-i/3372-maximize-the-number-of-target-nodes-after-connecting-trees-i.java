class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n=edges1.length+1;
        int m=edges2.length+1;
        int[] count1=build(edges1,k);
        int[] count2=build(edges2,k-1);
        int maxCount2=0;
        for(int c:count2){
            if(maxCount2<c){
                maxCount2=c;
            }
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=count1[i]+maxCount2;
        }
        return res;
    }

    private int[] build(int[][] edges, int k){
        int n=edges.length+1;
        List<List<Integer>> ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            ls.get(edge[0]).add(edge[1]);
            ls.get(edge[1]).add(edge[0]);
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=dfs(i,-1,ls,k);
        }
        return res;
    }
    // private int bfs(int start, List<List<Integer>> ls, int k){
    //     int count=0;
    //     Queue<int[]> q=new LinkedList<>();
    //     boolean vis[]=new boolean[ls.size()];

    //     q.offer(new int[]{start,0});
    //     vis[start]=true;

    //     while(!q.isEmpty()){
    //         int[] curr=q.poll();
    //         int node=curr[0];
    //         int dist=curr[1];
    //         if(dist>k){
    //             continue;
    //         }
    //         count++;

    //         for(int neighbor: ls.get(node)){
    //             if(!vis[neighbor]){
    //                 vis[neighbor]=true;
    //                 q.offer(new int[]{neighbor,dist+1});
    //             }
    //         }
            
    //     }
    //     return count;
    // }
    
    private int dfs(int node, int parent, List<List<Integer>> ls, int k){
        if(k<0){
            return 0;
        }
        int res=1;
        for(int child: ls.get(node)){
            if(child==parent){
                continue;
            }
            res+=dfs(child,node,ls,k-1);
        }
        return res;
    }
}