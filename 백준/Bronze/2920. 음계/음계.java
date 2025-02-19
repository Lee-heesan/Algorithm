import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char [] c = {'c','d','e','f','g','a','b','C'};
	static String [] str= {"cdefgabC","Cbagfedc"};
	static String [] result = {"ascending", "descending" , "mixed"};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String mix = "";
		for(int i =1; i<=8; i++) {
			int num = Integer.parseInt(st.nextToken());
			mix += c[num-1];
		}
		
		
		if(str[0].equals(mix)) {
			sb.append(result[0]);
		}else if (str[1].equals(mix)) {
			sb.append(result[1]);
		}else {
			sb.append(result[2]);
		}
		
		System.out.println(sb.toString());
	}

}
