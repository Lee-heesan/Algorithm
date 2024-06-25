
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		double A [] = new double[num];
		double max =0;
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<num;i++) { // 각 점수 대입
			A[i]=Double.parseDouble(st.nextToken());
			if(max<A[i]) {
				max = A[i];
			}
		}
		for(int k =0; k<num; k++) {
			A[k]= A[k]/max*100;
		}
		
		
		double avg;
		double sum=0;
		for(int j =0; j<num; j++) { // 평균
			sum += A[j];
		}
		avg = sum/num;
		System.out.printf("%.6f",avg);
	}

}
