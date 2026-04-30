class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    //     List<List<Integer>> graph=new ArrayList<>();
    //     for(int i=0;i<numCourses;i++){
    //         graph.add(new ArrayList<>());
    //     }
    //     for(int[] pre : prerequisites){
    //         int u=pre[0];
    //         int v=pre[1];
    //         graph.get(u).add(v);
    //     }
    //     List<Boolean> result=new ArrayList<>();
    //     for(int query[]:queries){
    //         int u=query[0];
    //         int v=query[1];
    //         result.add(bfs(graph,u,v,numCourses));
    //     }
    //     return result;
    // }
    // public boolean bfs(List<List<Integer>> graph,int start,int target,int n){
    //     Queue<Integer> q=new LinkedList<>();
    //     boolean[] vis=new boolean[n];
    //     q.add(start);
    //     vis[start]=true;
    //     while(!q.isEmpty()){
    //         int node=q.poll();
    //         if(node==target)return true;
    //         for(int neigh:graph.get(node)){
    //             if(!vis[neigh]){
    //                 vis[neigh]=true;
    //                 q.add(neigh);
    //             }
    //         }
    //     }
    //     return false;

    boolean[][] reach=new boolean[numCourses][numCourses];
        for(int pre[]:prerequisites){
            reach[pre[0]][pre[1]]=true;
        }
        for(int i=0;i<numCourses;i++){
            for(int j=0;j<numCourses;j++){
                for(int k=0;k<numCourses;k++){
                    if(reach[j][i] && reach[i][k]){
                        reach[j][k]=true;
                    }
                }
            }
        }
        List<Boolean> result=new ArrayList<>();
        for(int[] query:queries){
            int u=query[0];
            int v=query[1];
            result.add(reach[u][v]);
        }
        return result;
    }
}