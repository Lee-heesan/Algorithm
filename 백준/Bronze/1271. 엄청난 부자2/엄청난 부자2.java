import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        BigInteger n = new BigInteger(s[0]);
        BigInteger m = new BigInteger(s[1]);

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
    }
}