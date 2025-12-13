class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ls=new ArrayList<>();

        List<String>e = new ArrayList();
        List<String>g = new ArrayList();
        List<String>p = new ArrayList();
        List<String>r = new ArrayList();
        for(int i=0;i<code.length;i++){
            boolean check=true;
            String s=code[i];
            if(s.equals("")){
                check=false;
                continue;
            }
            for(int j=0;j<s.length();j++){
                char ch=s.charAt(j);
                if(!((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch=='_') || (ch>='0' && ch<='9'))){
                    check=false;
                    break;
                }
            }
            if(!check)continue;
            String s1=businessLine[i];
            boolean check1=true;
            if(!(s1.equals("electronics") || s1.equals("grocery") || s1.equals("pharmacy") || s1.equals("restaurant")))check1=false;
            if(check1 && (check && isActive[i])){
                if(businessLine[i].startsWith("e"))e.add(code[i]);
                if(businessLine[i].startsWith("g"))g.add(code[i]);
                if(businessLine[i].startsWith("p"))p.add(code[i]);
                if(businessLine[i].startsWith("r"))r.add(code[i]);
            }
        }
        Collections.sort(e);
        Collections.sort(g);
        Collections.sort(p);
        Collections.sort(r);
        ls.addAll(e);
        ls.addAll(g);
        ls.addAll(p);
        ls.addAll(r);
        return ls;
    }
}