import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int [] arr;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		arr = new int[(int)Math.floor(Math.log10(Math.abs(num)))+1];
		
		
		int i = 0;
		while(num>0) {
			arr[i++]=num%10;
			num=num/10;
		}
		

		for(int j =0; j<arr.length-1; j++) {
			int max =arr[j];
			int maxIdx =j;
			for(int k=j+1; k<arr.length; k++) {
				if(max<arr[k]) {
					max = arr[k];
					maxIdx = k;
					
				}
			}
			swap(j,maxIdx);
		}
		
		for(int j =0; j<arr.length; j++) {
			sb.append(arr[j]);
		}
		
		System.out.println(sb.toString());

	}
	
	
	public static void swap(int A, int B) {
		int temp = arr[A];
		arr[A]= arr[B];
		arr[B]= temp;
	}

}
