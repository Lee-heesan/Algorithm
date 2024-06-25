
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int len = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");;
		int [] A = new int[len];
		int cnt=0;
		
		
		for(int i = 0; i<A.length;i++) {
			
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		int num = Integer.parseInt(br.readLine());
		
		for(int k =0; k < A.length; k++) {
			if(num==A[k]) {
				cnt++;
			}
		}
		bw.write(cnt+"\n");
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}
