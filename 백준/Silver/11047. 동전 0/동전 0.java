
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> arr;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new LinkedList<Integer>();
		
		for(int i =0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(K>=num) {
				arr.add(num);
			}
		}
		
		Collections.sort(arr);
		
		int count = 0;
		
		for(int i = arr.size()-1; i>=0;i--) {
			
//			System.out.print(i+ " "+ arr.get(i));
			count += K/arr.get(i);
			K = K%arr.get(i);
			
//			System.out.println(" Now Count is "+ count);
			if(K<0) {
				break;
			}
		}
		
		System.out.println(count);

	}

}
