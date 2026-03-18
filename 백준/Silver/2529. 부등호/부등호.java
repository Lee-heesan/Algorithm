import java.io.*;

public class Main {
	 static int k;
	 static String [] sign;
	 static boolean [] visited;
	 static String max=null;
	 static String min=null;
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 k = Integer.parseInt(br.readLine());
		 sign = br.readLine().split(" ");
		 visited = new boolean[10];
		 dfs(0,"");
		 
		 System.out.println(max);
		 System.out.println(min);
	 }
	 
	 public static void dfs(int depth, String str) {
		 if(depth>k) {
			 if(min==null) {
				 min = str;
			 }
			 max=str;
			 return;
		 }
		 
		 for(int i =0; i<=9; i++) {
			 if(visited[i]) {
				continue; 
			 }
			 if(depth==0 || check(str.charAt(depth - 1) - '0',i,sign[depth - 1])) {
				 visited[i] = true;
	             dfs(depth + 1, str + i);
	             visited[i] = false;
			 }
		}
	 }
	 
	 public static boolean check(int a, int b, String str) {
		 if(str.equals(">")) {
			 return a>b;
		 }
		 return a<b;
	 }
}