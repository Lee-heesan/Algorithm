
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int [] arrN;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine()," ");
		arrN = new int[N];
		
		for(int i = 0; i<N ; i++) {
			arrN[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);
		
		
		int M = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine()," ");
		
		
		for(int i = 0; i<M ; i++) {
			if(isFind(Integer.parseInt(st.nextToken()))) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);

	}
	
	public static boolean isFind(int A) {
		int min = 0;
		int max = arrN.length-1;
		while(max>=min) {
			int mid = (min+max)/2;
			
			if(arrN[mid]>A) {
				max=mid-1;
			}else if(arrN[mid]<A) {
				min=mid+1;
			}else if(arrN[mid]==A){
				return true;
			}
		}
		return false;
	}

}
