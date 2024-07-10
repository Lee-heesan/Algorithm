import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> L = new ArrayList<>();
		
		for(int i=1;i<=A;i++) {
			if(A%i==0) {
				L.add(i);
			}
		}
		if(L.size()<B) {
			System.out.println(0);
		}else {
			System.out.println(L.get(B-1));
		}
	}

}
