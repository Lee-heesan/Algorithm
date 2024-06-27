import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A [] = new int[26];
		
		for(int i =0; i<A.length;i++) {
			A[i]=-1;
		}
		
		String st = sc.nextLine();
		
		for(int j=0;j<st.length();j++) {
			char ch = st.charAt(j);
			
			if(A[ch-'a']==-1) {
				A[ch-'a']=j;
			}
		}
		
		for (int k : A) {
			System.out.print(k+" ");
		}
		

	}

}
