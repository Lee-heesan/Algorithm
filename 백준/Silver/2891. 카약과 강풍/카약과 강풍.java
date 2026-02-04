import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int S;
	static int R;
	static int [] team;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		team = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<S; i++) {
			int num = Integer.parseInt(st.nextToken());
			team[num]--;
		}

		st = new StringTokenizer(br.readLine());
		for(int j =0; j<R; j++) {
			int num = Integer.parseInt(st.nextToken());
			team[num]++;
		}
		
		for(int i = 1; i<N; i++) {
			if(team[i] == -1 && team[i+1] == 1) {
				team[i]++;
				team[i+1]--;
			}
			else if(team[i+1] == -1 && team[i] == 1) {
				team[i+1]++;
				team[i]--;
			}
		}
		
		int result = 0;
		for(int t : team) {
			if(t==-1) result++;
		}
		
		System.out.println(result);
	}

}
