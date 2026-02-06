import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int [] wrong = new int[N];
		int [] great = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			wrong[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			great[i] = Integer.parseInt(st.nextToken());
		}
		
		// 해당 순번
		int num = 0;
		//이전 위치
		int prev = 0;
		int result = 0;
		
		while(num<N) {
			// 최대의 수
			int diff = great[num] - wrong[num];
			
			if (diff == 0) {
                prev = 0; 
                num++;
                continue;
            }
			
			//계산
			if (prev != 0 && (prev > 0) == (diff > 0)) {
                int inc = Math.abs(diff) - Math.abs(prev);
                if (inc > 0) {
                	result += inc;
                }
            } else {
                result += Math.abs(diff);
            }

            prev = diff;
            num++;
        }
		System.out.println(result);
	}
}
