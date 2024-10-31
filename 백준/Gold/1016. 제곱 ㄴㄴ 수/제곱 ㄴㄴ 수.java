
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long min = Long.parseLong(st.nextToken());
		Long max = Long.parseLong(st.nextToken());
		
		long count = max-min+1;
		boolean[] check = new boolean[(int)count];
		
		 for (long i = 2; i * i <= max; i++) { 
	            long pow = i * i;
	            long start = min / pow;
	            
	            if (min % pow != 0) { 
	                start += 1;
	            }

	            for (long j = start; j * pow <= max; j++) {
	                int index = (int) (j * pow - min); 
	                if (!check[index]) { 
	                    check[index] = true;
	                    count--;
	                }
	            }
	        }
		
		
		System.out.println(count);
		
	}


}
