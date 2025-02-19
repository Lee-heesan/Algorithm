import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class Main {
    static int ans;
    static List<Character> operator;
    static List<Integer> nums;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
 
        operator = new ArrayList<>();
        nums = new ArrayList<>();
 
        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
            	operator.add(c);
                continue;
            }
            nums.add(c-'0');
        }

        
        ans = Integer.MIN_VALUE;
        DFS(nums.get(0), 0);

        System.out.println(ans);

    }
 
    // DFS, 백트래킹 활용.
    public static void DFS(int result, int opIdx) {
        if (opIdx >= operator.size()) {
            ans = Math.max(ans, result);
            return;
        }
 
        // 괄호가 없는 경우
        int res1 = calc(operator.get(opIdx), result, nums.get(opIdx + 1));
        DFS(res1, opIdx + 1);
 
        // 괄호가 있는 경우
        if (opIdx + 1 < operator.size()) {
            int res2 = calc(operator.get(opIdx + 1), nums.get(opIdx + 1), nums.get(opIdx + 2));
 
            DFS(calc(operator.get(opIdx), result, res2), opIdx + 2);
        }
    }
    
    // 연산
    public static int calc(char operator, int n1, int n2) {
        switch (operator) {
        case '+':
            return n1 + n2;
        case '-':
            return n1 - n2;
        case '*':
            return n1 * n2;
        }
        return -1;
    }
 
}
