class Solution {
    public class TrieNode{
        TrieNode children[]=new TrieNode[26];
        boolean isWord=false;
        public TrieNode(){

        }
    }
    TrieNode root=new TrieNode();
    boolean[][] flag;

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result=new HashSet<>();
        flag=new boolean[board.length][board[0].length];
        insert(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.children[board[i][j]-'a']!=null){
                    search(board,i,j,root,"",result);
                }
            }
        }
        return new LinkedList<>(result);
    }

    public void insert(String words[]){
        for(String word:words){
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.children[ch-'a']==null){
                    node.children[ch-'a']=new TrieNode();
                }
                node=node.children[ch-'a'];
            }
            node.isWord=true;
        } 
    }

    public void search(char[][] board,int i,int j,TrieNode node,String word,Set<String> result){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || flag[i][j] || node.children[board[i][j]-'a']==null){
            return;
        }
        flag[i][j]=true;
        node=node.children[board[i][j]-'a'];
        if(node.isWord){
            result.add(word+board[i][j]);
        }
        search(board,i+1,j,node,word+board[i][j],result);
        search(board,i-1,j,node,word+board[i][j],result);
        search(board,i,j-1,node,word+board[i][j],result);
        search(board,i,j+1,node,word+board[i][j],result);

        flag[i][j]=false;
    }
}