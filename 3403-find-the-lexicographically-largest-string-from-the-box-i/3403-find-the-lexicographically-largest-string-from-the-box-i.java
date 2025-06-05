class Solution {
    public String answerString(String word, int numFriends) {
        String result="";
        int n=word.length();
        int longestPossible=n-(numFriends-1);
        for(int i=0;i<n;i++){
            int canTake=Math.min(longestPossible,n-i);
            String subStr=word.substring(i,canTake+i);
            result=result.compareTo(subStr)>0 ? result:subStr;
        }
        return result;
    }
}