class TrieNode{
    TrieNode children[]=new TrieNode[26];
    boolean isEnd=false;
}

class WordDictionary {
    private TrieNode root;
    
    public WordDictionary() {
        root=new TrieNode();    
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node=node.children[idx];
        }
        node.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode node=root;
        return dfs(word,0,node);
    }

    public boolean dfs(String word,int index,TrieNode node){
        if(word.length()==index){
            return node.isEnd;
        }
        char ch=word.charAt(index);
        if(ch!='.'){
            int idx=ch-'a';
            if(node.children[idx]==null){
                return false;
            }
            return dfs(word,index+1,node.children[idx]);   
        }

        for(int i=0;i<26;i++){
            if(node.children[i]!=null){
                if(dfs(word,index+1,node.children[i])){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */