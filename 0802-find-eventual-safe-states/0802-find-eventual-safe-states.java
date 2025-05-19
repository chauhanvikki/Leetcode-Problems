class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ls=new ArrayList<>();
        boolean vis[]=new boolean[graph.length];
        boolean recSt[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(!cycle(graph, i,new boolean[graph.length], new boolean[graph.length],ls)){
                    ls.add(i);
                }
            }
        }
        return ls;
    }
    public static boolean cycle(int[][] graph, int curr,boolean[] vis,boolean[] recSt,List<Integer> ls){
        vis[curr]=true;
        recSt[curr]=true;
        for(int i=0;i<graph[curr].length;i++){
            int dest=graph[curr][i];
            if(!vis[dest]){
                if(cycle(graph,dest,vis,recSt,ls)){
                    return true;
                }
            }
            else if(recSt[dest]){
                return true;
            }
        }
        recSt[curr]=false;
        return false;
    }
}