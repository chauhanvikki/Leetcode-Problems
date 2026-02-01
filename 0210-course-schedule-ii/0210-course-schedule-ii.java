class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        boolean vis[]=new boolean[n];
        int ans[]=new int[n];
        Stack<Integer> st=new Stack<>();
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int state[]=new int[n];
        for(int pair[]:prerequisites){
            int pre=pair[1];
            int course=pair[0];
            graph.get(pre).add(course);
        }
        for(int i=0;i<n;i++){
            if(state[i]==0){
                if(!topo(graph,i,state,st)){
                    return new int[0];
                }
            }
        }
        int i=0;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i++;
        }
        return ans;
    }
    public boolean topo(List<List<Integer>> graph,int curr,int state[],Stack<Integer> st){
        state[curr]=1;
        for(int neigh:graph.get(curr)){
            if(state[neigh]==1){
                return false;
            }
            if(state[neigh]==0){
                if(!topo(graph,neigh,state,st))return false;
            }
        }
        state[curr]=2;
        st.push(curr);
        return true;
    }
}