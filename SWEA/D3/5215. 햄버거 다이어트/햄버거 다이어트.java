import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    static int N,L;
	static int max;
	static int [][] arr ;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st= new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			max=Integer.MIN_VALUE;
			arr = new int[N][2];
			
			for(int j=0; j<N;j++) {
				st= new StringTokenizer(br.readLine()," ");
				arr[j][0]=Integer.parseInt(st.nextToken());
				arr[j][1]=Integer.parseInt(st.nextToken());
			}
			
			bestStuff(0,0,0);
			sb.append("#").append(i+1).append(" "+max+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void bestStuff(int calorie , int score , int depth) {
		if(calorie>L) {
			return;
		}
		
		for(int i=depth;i<arr.length;i++) {
			if(calorie+arr[i][1]>L) {
				continue;
			}
			bestStuff(calorie + arr[i][1],score+arr[i][0],i+1);	
			max = Math.max(max, score+arr[i][0]);
		}
	}

}