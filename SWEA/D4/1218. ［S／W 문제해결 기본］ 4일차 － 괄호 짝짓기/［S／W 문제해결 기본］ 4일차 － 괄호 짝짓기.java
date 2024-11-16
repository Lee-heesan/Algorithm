import java.io.*;
import java.util.*;

class Solution
{
	static char [] arr;
	static boolean [] visited;
	static char [][] C = {{'(',')'},{'[',']'},{'{','}'},{'<','>'}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		for(int i =1; i<=10; i++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			arr = str.toCharArray();
			visited = new boolean[arr.length];
			boolean isTrue = true;
			for(int j=0; j<arr.length; j++) {
				if(visited[j]) {
					continue;
				}else {
					visited[j]=true;
					if(!find(j)) {
						isTrue = false;
						break;
					}
				}
			}
			
			sb.append("#").append(i).append(" ");
			if(!isTrue) {
				sb.append(0);
			}else {
				sb.append(1);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	
	}
	
	public static boolean find(int num) {
		int chNum = whatC(arr[num]);
		
		if(chNum==-1) {
			return false;
		}
		
		for(int i=num+1; i<arr.length; i++) {
			if(visited[i]) {
				continue;
			}
			if(arr[i]==C[chNum][1]) {
				visited[i]=true;
				return true;
			}
		}
		
		return false;
		
	}
	
	public static int whatC(char ch) {
		if(ch==C[0][0]) {
			return 0;
		}else if(ch ==C[1][0]) {
			return 1;
		}else if(ch == C[2][0]) {
			return 2;
		}else if(ch == C[3][0]) {
			return 3;
		}else {
			return -1;
		}
	}
}