
import java.util.Scanner;

public class Main {
	static int [] arr;
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int [2000001];
		for(int i = 2; i<arr.length; i++) {
			arr[i]=i;
		}
		
		
		arr[1]=0;
		// 소수 찾기
		for(int i = 2; i<=Math.sqrt(arr.length); i++) {
			if(arr[i]==0) {
				continue;
			}
			
			for(int j= i+i; j<arr.length; j = j + i) {
				arr[j] = 0;
			}
		}
		
		
		for(int i =N; i<arr.length; i++) {
			if(arr[i]!=0&&Palindrome(i)) {
				System.out.println(i);
				break;
			}
		}
		
		
	}
	public static boolean Palindrome(int i) {
		String str1 = String.valueOf(i);
		StringBuffer sb = new StringBuffer(str1);
		String str2 = sb.reverse().toString();
		if(str1.equals(str2)) {
			return true;
		}
		return false;
	}
}
