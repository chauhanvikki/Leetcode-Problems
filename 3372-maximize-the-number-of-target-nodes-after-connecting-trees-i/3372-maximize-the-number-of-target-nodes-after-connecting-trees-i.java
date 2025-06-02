class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n=edges1.length+1;
        int m=edges2.length+1;
        int[] res=new int[n];
        int[] count1=build(edges1,k);
        int[] count2=build(edges2,k-1);
        int maxi=0;
        for(int i=0;i<m;i++){
            if(maxi<count2[i]){
                maxi=count2[i];
            }
        }
        for(int i=0;i<n;i++){
            res[i]=count1[i]+maxi;
        }
        return res;
    }
    private int[] build(int[][] edges,int k){
        List<List<Integer>> ls=new ArrayList<>();
        int n=edges.length+1;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            ls.get(edge[0]).add(edge[1]);
            ls.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++){
            res[i]=dfs(i,-1,k,ls);
        }
        return res;
    }
    private int dfs(int node,int parent,int k,List<List<Integer>> ls){
        if(k<0){
            return 0;
        }
        int res=1;
        for(int child : ls.get(node)){
            if(child==parent){
                continue;
            }
            res+=dfs(child,node,k-1,ls);
        }
        return res;
    }
}