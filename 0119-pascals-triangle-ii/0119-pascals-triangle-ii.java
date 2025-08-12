class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        res.add(1);
        if(rowIndex==0){
            return res;
        }
        res.add(1);
        if(rowIndex==1)return res;
        int j=0;
        while(j<=rowIndex){
            List<Integer> ls=new ArrayList<>(res);
            res.clear();
            res.add(1);
            for(int i=1;i<j;i++){
                res.add(ls.get(i-1)+ls.get(i));
            }
            res.add(1);
            j++;
        }
        return res;
    }
}