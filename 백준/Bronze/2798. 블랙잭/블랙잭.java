import java.io.*;
import java.util.StringTokenizer;
import java.lang.Math;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] A = new int[N];
		
		
		st= new StringTokenizer(br.readLine()," ");
		for(int i =0; i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		
		int sum =0;
		int temp =0;
		
		for(int i=0; i<N-2 ; i++) {
			for(int j=i+1; j<N-1;j++) {
				for(int k=j+1;k<N;k++) {
					sum = A[i]+A[j]+A[k];
					if(sum > temp && sum <= M){ //이전 근사치보다 큰데 M보다 작거나 같다는 것은 이전 근사치보다 M에 가깝다는 뜻
                        temp = sum;
                    }
				}
			}
		}
		
		System.out.println(temp);
	}

}
