
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		String [][] arr = new String [N][2];
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		
		Arrays.sort(arr, new Comparator<String []>() {
			public int compare(String [] e1 , String [] e2) {
				int e1I = Integer.parseInt(e1[0]);
				int e2I = Integer.parseInt(e2[0]);
				
				return e1I-e2I;
			}
		});
		
		for(int i =0; i<N; i++) {
			System.out.println(arr[i][0] +" "+arr[i][1]);
		}
		

	}

}
