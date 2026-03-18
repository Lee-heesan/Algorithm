import java.io.*;

public class Main{
	 static int k;
	    static String[] sign;
	    static boolean[] visited = new boolean[10];
	    static String min = null;
	    static String max = null;

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        k = Integer.parseInt(br.readLine());
	        sign = br.readLine().split(" ");

	        dfs(0, "");

	        System.out.println(max);
	        System.out.println(min);
	    }

	    static void dfs(int depth, String num) {
	        if (depth == k + 1) {
	            if (min == null) {
	            	min = num;
	            }
	            max = num;
	            return;
	        }

	        for (int i = 0; i <= 9; i++) {
	            if (visited[i]) {
	            	continue;
	            }

	            if (depth == 0 || check(num.charAt(depth - 1) - '0', i, sign[depth - 1])) {
	                visited[i] = true;
	                dfs(depth + 1, num + i);
	                visited[i] = false;
	            }
	        }
	    }

	    static boolean check(int a, int b, String op) {
	        if (op.equals("<")) {
	        	return a < b;
	        }
	        return a > b;
	    }
}