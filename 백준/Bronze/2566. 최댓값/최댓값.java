
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int [][] A = new int[9][9];
		int max = -1;
		int max_row = 0;
		int max_column =0;
		
		for(int i =0; i<9;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0; j<9;j++) {
				A[i][j]= Integer.parseInt(st.nextToken());
				if(max<A[i][j]) {
					max = A[i][j];
					max_row = i+1;
					max_column = j+1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(max_row+" "+max_column);

	}

}
