class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String,List<Character>> hm=new HashMap<>();
        for(int i=0;i<allowed.size();i++){
            String s=allowed.get(i);
            if(!hm.containsKey(s.substring(0,2))){
                hm.put(s.substring(0,2),new ArrayList<>());
            }
            hm.get(s.substring(0,2)).add(s.charAt(2));
        }
        return helper(bottom,"",0,hm);
    }
    public boolean helper(String bottom,String next,int index,HashMap<String,List<Character>> hm){
        if(bottom.length()==1)return true;
        if(index==bottom.length()-1){
            return helper(next,"",0,hm);
        }

        String pair=bottom.substring(index,index+2);
        if(!hm.containsKey(pair))return false;

        for(char ch:hm.get(pair)){
            if(helper(bottom,next+ch,index+1,hm))return true;
        }
        return false;
    }
}