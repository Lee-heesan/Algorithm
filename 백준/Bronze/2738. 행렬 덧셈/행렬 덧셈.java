import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," "); ;
		int column =Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int [][] Arrangement = new int[column][row];
		
		for(int i = 0; i<2;i++) {
			for(int j=0; j<column;j++) {
				st= new StringTokenizer(br.readLine()," ");
				for(int k=0; k<row;k++) {
					Arrangement[j][k] += Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for(int i=0;i<column;i++) {
			for(int j =0; j<row;j++) {
				System.out.print(Arrangement[i][j]+" ");
			}
			System.out.println();
		}

	}

}
