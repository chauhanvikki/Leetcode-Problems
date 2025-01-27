import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger n=new BigInteger (a,2);
        BigInteger n1=new BigInteger (b,2);
        BigInteger sum=n.add(n1);
        return sum.toString(2);
    }
}