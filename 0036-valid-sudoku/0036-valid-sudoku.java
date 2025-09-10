class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num=board[i][j];
                if(num=='.')continue;
                String row=num+"In row "+i;
                String col=num+"In col "+j;
                String box=num+"In box "+i/3 + "-"+ j/3;
                if(hs.contains(row)||hs.contains(col)||hs.contains(box)){
                    return false;
                }
                hs.add(row);
                hs.add(col);
                hs.add(box);
            }
        }
        return true;
    }
}