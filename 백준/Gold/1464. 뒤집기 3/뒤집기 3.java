import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        Deque<Character> dq = new ArrayDeque<>();
        dq.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= dq.peekFirst()) dq.addFirst(c);
            else dq.addLast(c);
        }

        StringBuilder ans = new StringBuilder();
        while (!dq.isEmpty()) ans.append(dq.pollFirst());
        System.out.println(ans);
    }
}
