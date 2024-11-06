
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// 1043 유니온 파인드
	public static int[] parent;
	public static int[] trueP;
	public static ArrayList<Integer> [] party;
	public static int result;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		result =0;
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i]=i;
		}
		
		int T = sc.nextInt();
		trueP = new int[T];
		for(int i=0; i<T; i++) {
			trueP[i] =sc.nextInt();
		}

		party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			party[i]= new ArrayList<Integer>();
			int party_size = sc.nextInt();
			for(int j=0; j<party_size; j++) {
				party[i].add(sc.nextInt());
			}
		}
		
		
		for(int i=0; i<M; i++) {
			int firstPeople = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		for(int i=0; i<M; i++) {
			boolean isPossible = true;
			int cur = party[i].get(0);
			
			for(int j =0; j<trueP.length; j++) {
				if(find(cur)==find(trueP[j])) {
					isPossible = false;
					break;
				}
			}
			
			if(isPossible) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	public static void union(int a, int b) {
		a= find(a);
		b= find(b);
		
		if(a!=b) {
			parent[b]=a;
		}
	}
	
	public static int find(int num) {
		if(parent[num]==num) {
			return num;
		}
		return parent[num]= find(parent[num]);
	}
	
}
