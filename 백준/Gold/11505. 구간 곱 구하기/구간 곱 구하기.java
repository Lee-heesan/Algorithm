
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long [] tree;
	static int size;
	static int n, m, k;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		size = 1;
		while(size<n) {
			size *= 2;
		}
		tree = new long[size*2];
		
		for(int i=size; i<size+n; i++) {
			tree[i] =Long.parseLong(br.readLine());
		}
		
		build();
		
		for(int i = 0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			
			if(a==1) {
				update(size+b-1,c);
			}else if (a==2) {
				sb.append(query(size+b-1,size+(int)c-1)).append("\n");
			}
		}
		
		System.out.println(sb.toString());

	}
	
	private static long query(int start, int end) {
	    long paramSum = 1;

	    while (start <= end) {
	        if (start == end) {
	            paramSum = (paramSum * tree[start]) % 1000000007; 
	            break;
	        }

	        if (start % 2 == 1) { 
	            paramSum = (paramSum * tree[start]) % 1000000007; 
	            start++;
	        }
	        if (end % 2 == 0) { 
	            paramSum = (paramSum * tree[end]) % 1000000007; 
	            end--;
	        }

	        start /= 2;
	        end /= 2;
	    }

	    return paramSum;
	}
	
	private static void update(int idx, long value) {
	    tree[idx] = value;

	    while (idx > 1) {
	        idx /= 2;
	        tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % 1000000007; 
	    }
	}

	private static void build() {
	    for (int i = size - 1; i > 0; i--) {
	        tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % 1000000007; 
	    }
	}

}
