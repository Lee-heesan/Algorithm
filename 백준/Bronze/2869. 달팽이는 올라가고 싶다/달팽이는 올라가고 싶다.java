import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		int day = (target - down) / (up - down);
        
		if ((target - down) % (up - down) != 0) {
			day++;
		}
		System.out.println(day);
	}

}
