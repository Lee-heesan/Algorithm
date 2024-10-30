
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;
	static long A,B;
	static long [] arr;
	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		arr = new long[10000001];
		for(int i = 2; i<arr.length; i++) {
			arr[i]=i;
		}

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < arr.length; j = j + i) { 
                arr[j] = 0;
            }
        }
       
        // 거의 소수
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {
                long temp = arr[i];
                while ((double) arr[i] <= (double)B/(double)temp) {
                    if ((double) arr[i] >= (double)A/(double)temp ) {
                        count++;
                    }
                    temp = temp * arr[i];
                }
            }
        }
		
		
		System.out.println(count);
	}
	
}
