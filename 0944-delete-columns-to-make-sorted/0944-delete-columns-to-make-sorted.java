class Solution {
    public int minDeletionSize(String[] strs) {
        char[][] grid=new char[strs.length][strs[0].length()];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<strs[0].length();j++){
                char ch=strs[i].charAt(j);
                grid[i][j]=ch;
            }
        }
        int count=0;
        for(int i=0;i<strs[0].length();i++){
            int prev=0;
            for(int j=0;j<strs.length;j++){
                char ch=strs[j].charAt(i);
                int a=(int)ch;
                if(a<prev){
                    count++;
                    prev=0;
                    break;
                }
                prev=a;
            }
        }
        return count;
    }
}