
import java.util.Scanner;

public class Main {
	static int [] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		
		bubble(N);
		
		for(int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}

	}
	
	public static void bubble(int N) {
		int count =0; 
		while(N>count) {
			for(int i=1; i<arr.length-count; i++) {
				if(arr[i]<arr[i-1]) {
					swap(i,(i-1));
				}
			}
			count++;
		}
	}
	
	public static void swap(int A , int B) {
		int tmp = arr[B];
		arr[B] = arr[A];
		arr[A] = tmp;
	}

}
