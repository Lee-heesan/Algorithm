import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int [] parent;
	static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = 0;
		
		parent = new int [n];
		for(int i =0; i<n; i++) {
			parent[i]=i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			union(start, end, i+1);
		}

		System.out.println(result);
	}
	
	private static void union(int p1, int p2, int how) {
		int parent1 = find(p1);
		int parent2 = find(p2);
		
		
		if(parent1>parent2) {
			parent[parent2] = parent1;
		}else if(parent2>parent1) {
			parent[parent1] = parent2;
		}else {
			if(result==0) {
				result = how;	
			}
		}
	}
	
	private static int find (int o1) {
		if(parent[o1]==o1) {
			return o1;
		}
		
		return parent[o1] = find(parent[o1]);
	}
}
