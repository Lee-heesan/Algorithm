import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int A [] = new int[30];
		int n;
		for(int k=0; k<30;k++) { //모든값에 0 넣기
			A[k]=0;
		}
		
		for(int i =0; i<28;i++) { //출석부르기
			n=sc.nextInt();
			if(A[n-1]==1) {
				break;
			}else {
				A[n-1]=1;
			}
		}
		
		for(int j=0; j<30;j++) { //찾아내기
			if(A[j]==0) {
				System.out.println(j+1);
			}
		}
	}

}
