
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long [] tree;
	static int size;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		size = 1;
		while(size<N) {
			size *= 2;
		}
		tree = new long[size*2];
		
		for(int i = size; i<size+N; i++) {
			tree[i]=Long.parseLong(br.readLine());
		}
		
        build();
        
        for(int i = 0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	sb.append(query(size + a-1,size + b-1)).append("\n");
        }
		System.out.println(sb.toString());
	}
	
	private static int query(int start, int end) {
		int partSum =Integer.MAX_VALUE;
		while(start<=end) {
			if(start==end) {
				partSum = (int) Math.min(partSum, tree[end]);
				break;
			}
			
			if(start%2 == 1&&tree[start]!=0) {
				partSum = (int) Math.min(partSum, tree[start]);
			}
			if(end%2 == 0&&tree[end]!=0) {
				partSum = (int) Math.min(partSum, tree[end]);
			}
			
			start = (start+1)/2;
			end = (end-1)/2;
		}
		
		return partSum;
	}
	
	private static void build() {
		for(int i = size-1; i>0; i--) {
			tree[i] = Math.min(tree[i*2], tree[(i*2)+1]);
		}
	}

}
