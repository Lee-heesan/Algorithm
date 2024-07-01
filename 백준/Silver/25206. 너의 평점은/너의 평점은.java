import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String subject [] = new String[20];
		StringTokenizer st ;
		double sum = 0;
		double result;
		double grade = 0;
		double grade_sum=0;
		for(int i =0; i<20;i++) {
			st= new StringTokenizer(br.readLine()," ");
			subject[i] = st.nextToken();
		    grade = Double.parseDouble(st.nextToken());
			double score = 0;
			switch (st.nextToken()) {
				case "A+":
					score = 4.5;
					break;
				case "A0":
					score = 4.0;
					break;
				case "B+":
					score = 3.5;
					break;
				case "B0":
					score = 3.0;
					break;
				case "C+":
					score = 2.5;
					break;
				case "C0":
					score = 2.0;
					break;
				case "D+":
					score = 1.5;
					break;
				case "D0":
					score = 1.0;
					break;
				case "F":
					score = 0.0;
					break;
				case "P":
					score = 0.0;
					grade = 0.0;
					break;
			}
			sum +=(grade*score);
			grade_sum+=grade;
		}
		result = sum/grade_sum;
		System.out.printf("%f",result);
	}

}
