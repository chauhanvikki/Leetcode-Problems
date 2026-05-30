class Solution {
    public int calPoints(String[] s) {
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<s.length;i++){
            if(s[i].equals("+")){
                ls.add(ls.get(ls.size()-2)+ls.get(ls.size()-1));
            }
            else if(s[i].equals("C")){
                ls.remove(ls.get(ls.size()-1));
            }
            else if(s[i].equals("D")){
                ls.add(ls.get(ls.size()-1)*2);
            }
            else{
                ls.add(Integer.parseInt(s[i]));
            }
        }
        int sum=0;
        for(int i=0;i<ls.size();i++){
            sum+=ls.get(i);
        }
        return sum;
    }
}