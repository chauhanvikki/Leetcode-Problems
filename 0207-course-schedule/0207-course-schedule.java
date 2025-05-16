class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        boolean vis[]=new boolean[n];
        boolean recSt[]=new boolean[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int course=pair[0];
            int prereq=pair[1];
            graph.get(prereq).add(course);
        }
        for(int i=0;i<n;i++){
            if(topo(graph,i,vis,recSt)){
                return false;
            }
        }
        return true;
    }
    public boolean topo(List<List<Integer>> graph,int curr, boolean[] vis, boolean recSt[]){
        vis[curr]=true;
        recSt[curr]=true;
        for(int dest : graph.get(curr)){
            if(!vis[dest]){
                if(topo(graph,dest,vis,recSt)){
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