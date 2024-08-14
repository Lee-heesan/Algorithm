import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution
{
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		for(int i =0 ; i <10; i++) {
			int N = Integer.parseInt(br.readLine());
			int [] arr= new int [N];
			
			st = new StringTokenizer(br.readLine()," ");
			
			for(int j =0 ; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			sb.append("#"+(i+1)+" "+calculate(arr)+"\n");
		}
		
		System.out.println(sb);

	}
	public static int calculate(int [] arr) {
		int view =0;
		for(int i =2; i<arr.length-2; i++) {
			if(arr[i-1]<arr[i]&&arr[i-2]<arr[i]&&arr[i]>arr[i+1]&&arr[i]>arr[i+2]) {
				view += minClass(arr,i);
				i+=2;
			}else {
				continue;
			}
		}
		return view;
	}
	
	public static int minClass(int [] arr, int i) {
		int min = Integer.MAX_VALUE;
		for(int k=i-2; k<i+3; k++) {
			if(k==i) {
				continue;
			}
			min = Math.min(min,arr[i]-arr[k]);
		}
		return min;
	}

}
