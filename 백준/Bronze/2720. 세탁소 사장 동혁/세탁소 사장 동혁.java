import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [][] A = new int [n][4];
		
		for(int i =0; i<n;i++) {
			int num = sc.nextInt();
			if(num/25>0) {
				A[i][0]=num/25;
				num=num%25;
			}
			if(num/10>0) {
				A[i][1]=num/10;
				num=num%10;
			}
			if(num/5>0) {
				A[i][2]=num/5;
				num=num%5;
			}
			if(num>0) {
				A[i][3]=num;
				num=0;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
