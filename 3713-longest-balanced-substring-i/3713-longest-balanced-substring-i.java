class Solution {
    public int longestBalanced(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int[] freq=new int[26];
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                int mini=Integer.MAX_VALUE;
                int maxi=0;
                for(int k=0;k<26;k++){
                    if(freq[k]!=0){
                        mini=Math.min(mini,freq[k]);
                        maxi=Math.max(maxi,freq[k]);
                    }
                }
                if(mini==maxi)ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}