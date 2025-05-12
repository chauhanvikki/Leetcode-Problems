class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> hs=new HashSet<>(); 
        for(int i=0;i<digits.length;i++){
            for(int j=0;j<digits.length;j++){
                for(int k=0;k<digits.length;k++){
                    if(i!=j && j!=k && k!=i){
                        int num=digits[i]*100 + digits[j]*10 + digits[k];
                        if(num>99){
                            if(num%2==0){
                                hs.add(num);
                            }
                        }
                    }
                }
            }
        }
        return hs.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}