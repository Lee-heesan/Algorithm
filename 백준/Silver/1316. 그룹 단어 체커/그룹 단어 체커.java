import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		int count =0;
		
		for(int i=0; i<n; i++) {
			if(check()==true) {
				count++;
			}
		}
		
		System.out.println(count);

	}
	public static boolean check() {
		boolean [] A = new boolean [26];
		String word = sc.next();
		int prev = 0;
		
		
		for(int i=0;i<word.length();i++) {
			int now = word.charAt(i);
			if(prev!=now) {
				if ( A[now - 'a'] == false ) {
					A[now - 'a'] = true;		
					prev = now;					
				}
				else {
					return false;
				}
			}
			else {
				continue;
			}
		}
		return true;
	}

}
