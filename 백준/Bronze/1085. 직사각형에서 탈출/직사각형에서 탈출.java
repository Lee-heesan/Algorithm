
import java.io.*;
import java.util.StringTokenizer;
import java.lang.Math;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int squareX = Integer.parseInt(st.nextToken());
		int squareY = Integer.parseInt(st.nextToken());
		
		
		int x_min = Math.min(x, squareX-x);
		int y_min = Math.min(y, squareY-y);
		
		System.out.println(Math.min(x_min, y_min));
	}

}
