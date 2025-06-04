class Solution {
    public String answerString(String word, int numFriends) {
        String result="";
        int n=word.length();
        if (numFriends == 1) {
            return word; 
        }
        if (n == 1 ) {
            return word.substring(0, 1);  
        }
        int longestPossi=n-(numFriends-1);
        for(int i=0;i<n;i++){
            int canTake=Math.min(longestPossi,n-i);
            result=result.compareTo(word.substring(i,i+canTake))>0 ? result : word.substring(i,i+canTake);
        }
        return result;
    }
}