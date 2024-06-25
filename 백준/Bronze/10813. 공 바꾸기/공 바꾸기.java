import java.io.*;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int len = Integer.parseInt(st.nextToken());
		int A [] = new int [len];
		int count = Integer.parseInt(st.nextToken());
		int tmp;
		
		for(int k=1;k<=A.length;k++) {//생성
			A[k-1]=k;
		}
		int q;
		int w;
		for(int i =0; i<count;i++) {//교환
			st= new StringTokenizer(br.readLine()," ");
			
			q=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			
			tmp = A[q-1];
			A[q-1]=A[w-1];
			A[w-1]=tmp;
		}
		
		
		for (int j =0; j<A.length; j++) {//출력
			bw.write(A[j]+" ");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
