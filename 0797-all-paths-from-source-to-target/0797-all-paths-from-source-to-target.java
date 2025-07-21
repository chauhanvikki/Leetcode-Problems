class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(res,path,graph,0);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> path,int[][] graph, int curr){
        if(curr==graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i:graph[curr]){
            path.add(i);
            dfs(res,path,graph,i);
            path.remove(path.size()-1);
        }
    }
}