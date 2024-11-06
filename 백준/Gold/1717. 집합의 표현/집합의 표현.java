
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //1717
	static int [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for(int i =1; i<=N; i++) {
			arr[i] = i;
		}
		
		for(int i= 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(H==1) {
				if(find(A)==find(B)) {
					sb.append("YES"+"\n");
				}else {
					sb.append("NO"+"\n");
				}
			}else {
				union(A,B);
			}
		}
		
		System.out.println(sb.toString());

	}
	
	public static void union(int num1 ,int num2) {
		int rootX = find(num1);
        int rootY = find(num2);

        if (rootX != rootY) { // 루트가 다를 때만 합침
            arr[rootY] = rootX; // y의 루트를 x의 루트로 변경
        }
		
	}
	
	
	public static int find(int num) {
		if(num==arr[num]) {
			return num;
		}
		
		return arr[num] = find(arr[num]);
	}

}
