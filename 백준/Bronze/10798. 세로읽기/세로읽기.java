
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		char [][] Arrangement = new char [5][15];
		int max_row=0;
		
		for(int i=0;i<5;i++) {
			String A = br.readLine();
			A=A.trim();
			for(int j=0; j<A.length();j++) {
				Arrangement[i][j]=A.charAt(j);
			}
			if(max_row<A.length()) {
				max_row=A.length();
			}
		}
		
		
		for(int i=0;i<max_row;i++) {
			for(int j=0;j<5;j++) {
				if(Arrangement[j][i]==0) {
					continue;
				}else {
					System.out.print(Arrangement[j][i]);
				}
			}
		}
	}

}
