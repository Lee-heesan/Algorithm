
import java.io.*;
import java.util.HashMap;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb ;
		int N = Integer.parseInt(br.readLine());
		int [] arr =new int[N];
		int [] arr2 = new int[N];
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i =0 ; i<N; i++) {
			arr2[i]=arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr2);
		int rank = 0;
		
		for(int i=0; i<N; i++) {
			if(!rankingMap.containsKey(arr2[i])) {
				rankingMap.put(arr2[i],rank);
				rank++;
			}
		}
		
		sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(rankingMap.get(arr[i])).append(" ");
		}
		System.out.print(sb);
	}

}
