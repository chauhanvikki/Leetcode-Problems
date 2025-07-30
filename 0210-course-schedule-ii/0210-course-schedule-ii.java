class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int arr[]=new int[numCourses];
        int inDig[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int course[]:prerequisites){
            inDig[course[0]]++;
            adj.get(course[1]).add(course[0]);
        }
        boolean vis[]=new boolean[numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDig[i]==0){
                q.add(i);
            }
        }

        int k=0;
        while(!q.isEmpty()){
            int curr=q.remove();
            arr[k++]=curr;
            for(int neighbor: adj.get(curr)){
                inDig[neighbor]--;
                if(inDig[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        if(numCourses!=k)return new int[0];
        return arr;
    }
}