
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] sortArr = new int[N];
		for (int i = 0; i < N; i++) {
			sortArr[i] = Integer.parseInt(br.readLine());
		} // 정렬 전
		br.close();
		
		Radix radix = new Radix();
		radix.radixsort(sortArr);
		
		for (int sortAfter : sortArr) {
			bw.write(sortAfter + "\n");
		} // 정렬 후
		bw.flush();
		bw.close();
		
	}
	
	
	static class Radix{
		public int getMax(int [] data) {
			int max = data[0];
			for(int i=1; i<data.length; i++) {
				if(data[i] > max) {
					max = data[i];
				}
			}
			return max;
		}
		
		public void countSort(int[] data, int exp) {
			int[] output = new int[data.length];
			int[] count = new int[10];
			
			for(int i=0; i<data.length; i++) {
				count[(data[i]/exp)%10]++;
			}
			
			for(int i=1; i<10; i++) {
				count[i] += count[i-1];
			}
			
			for(int i=data.length-1; i>=0; i--) {
				output[count[(data[i]/exp%10)]-1] = data[i];
				count[(data[i]/exp)%10]--;
			}
			
			for(int i=0; i<data.length; i++) {
				data[i] = output[i];
			}
		}
		
		public void radixsort(int[] data) {
			int m = getMax(data);
			for(int exp=1; m/exp>0; exp*=10) {
				countSort(data, exp);
			}
		}
	}

}
