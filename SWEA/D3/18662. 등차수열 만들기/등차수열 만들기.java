import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	 {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		double [] answer =  new double [N];
		
		for(int i = 0; i<N; i++) {
			int [] arr = new int[3];
			st= new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<arr.length; j++) {
				arr[j]= Integer.parseInt(st.nextToken());
			}
			if(arr[1] - arr[0] != arr[2] - arr[1]) {
				answer[i]=calculate(arr);
			}else {
				answer[i]=0;
			}
		}

		for(int i = 0; i<N ; i++) {
			System.out.println("#"+(i+1)+" "+answer[i]);
		}
		
	}
	
	public static double calculate(int [] arr) {
		int tmp1 = arr[1] - arr[0];
		int tmp2 = arr[2] - arr[1];
		
		if(tmp1<tmp2) {
			return (tmp2-tmp1)/2.0;
		}
		else if(tmp1>tmp2) {
			return (tmp1-tmp2)/2.0;
		}
		
		return (Math.abs(tmp2)+Math.abs(tmp1))/2.0;
	}

}
