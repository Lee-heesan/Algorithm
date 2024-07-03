import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		boolean [][] A = new boolean[101][101];
		int n = sc.nextInt();
		int count =0;
		
		for(int i =0; i<n;i++) {
			int left = sc.nextInt();
			int bottom = sc.nextInt();
			for(int j =left; j<left+10;j++) {
				for(int k =bottom; k<bottom+10;k++) {
					if(A[j][k]!=true) {
						A[j][k]=true;
						count++;
					}
				}
			}
		}
		
		System.out.print(count);

	}

}
