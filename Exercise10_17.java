import java.math.BigInteger;
public class Exercise10_17 {
	public static void main(String[] args){
        long n = (long) Math.floor(Math.sqrt(Long.MAX_VALUE));
        BigInteger[] ns = new BigInteger[10];
        BigInteger[] n2s = new BigInteger[10];
        for (int i = 0; i < 10; i++) {
            Long temp = i + n + 1;
            ns[i] = new BigInteger(temp.toString());
            n2s[i] = ns[i].pow(2);
            System.out.println(n2s[i]);
		}
		
	}
}