import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String num = sc.next();
		int [] isCheck = new int[10];
		char[] arr = num.toCharArray();
		
		int result = 0;
		
		for(char n : arr) {
			if(isCheck[n-'0']==result) {
				if(n-'0'==6) {
					if(isCheck[9]==result) {
						result++;
					}
					isCheck[9]++;
				}else if (n-'0'==9){
					if(isCheck[6]==result) {
						result++;
					}
					isCheck[6]++;
				}else {
					isCheck[n-'0']++;
					result++;
				}
			}else {
				isCheck[n-'0']++;
			}
		}
		
		System.out.print(result);
	}

}
