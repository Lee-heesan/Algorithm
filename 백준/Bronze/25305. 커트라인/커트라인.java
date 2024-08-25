
import java.io.*;
import java.text.CollationElementIterator;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Integer [] arr = new Integer [N];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,Collections.reverseOrder());
		int cutLine = arr[k-1] ;
		System.out.println(cutLine);
	}

}
