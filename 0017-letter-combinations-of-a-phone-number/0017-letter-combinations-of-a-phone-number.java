class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> hm=new HashMap<>();
        String s="abcdefghijklmnopqrstuvwxyz";
        int pos=2;
        int start=0,end=3;
        for(int i=2;i<=9;i++){
            if(i==7 || i==9){
                hm.put(i,s.substring(start,end+1));
                start=start+4;
                end=end+4;
            }
            else{
                hm.put(i,s.substring(start,end));
                start=start+3;
                end=end+3;
            }
        }
        List<String> ls=new ArrayList<>();
        helper(ls,hm,digits,0,"");
        return ls;
    }
    public void helper(List<String> ls,HashMap<Integer,String> hm,String digits,int index,String curr){
        if(digits.length()==index){
            ls.add(curr);
            return;
        }
        int key=digits.charAt(index)-'0';
        String letter=hm.get(key);
        for(int i=0;i<letter.length();i++){
            helper(ls,hm,digits,index+1,curr+letter.charAt(i));
        }
    }
}