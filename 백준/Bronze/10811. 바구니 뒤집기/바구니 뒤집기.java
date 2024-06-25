import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int no = sc.nextInt();
		int num = sc.nextInt();

		int A [] = new int[no];
		
		
		for(int k=0; k<no;k++)	{ // 대입
		  A[k]=k+1;	
		}
		
		int q;
		int w;
		int temp;
		for(int i=0; i<num;i++) { // 수헹
			q = sc.nextInt();
			w = sc.nextInt();
			
			for(int j=q;j!=w&&j<w;j++, w--) {
				temp=A[j-1];
				A[j-1]=A[w-1];
				A[w-1]=temp;
			}
			
		}
		
		for(int e=0; e<no;e++) {
			System.out.print(A[e]+" ");
		}

	}

}
