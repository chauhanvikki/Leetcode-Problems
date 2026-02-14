class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited=new HashSet<>(wordList);
        if(!visited.contains(endWord))return 0;
        int level=1;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String current=q.poll();
                if(current.equals(endWord))return level;
                char[] arr=current.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char original=arr[j];
                    for(char ch='a';ch<='z';ch++){
                        arr[j]=ch;
                        String newSt=new String(arr);
                        if(!visited.contains(newSt))continue;
                        if(visited.contains(newSt)){
                            q.offer(newSt);
                            visited.remove(newSt);
                        }
                    }
                    arr[j]=original;
                }
            }
            level++;
        }
        return 0;
    }
}