import java.io.*;
import java.util.*;

public class Main {
    static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        if (n == 0 && m == 0) {
            System.out.println(0);
            return;
        }

        long g = gcd(n, m);
        System.out.println(g == 1 ? 1 : 2);
    }
}
