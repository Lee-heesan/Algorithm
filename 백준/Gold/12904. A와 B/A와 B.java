import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		StringBuilder tb = new StringBuilder(T);
		while(tb.length()>S.length()) {
			char last = tb.charAt(tb.length()-1);
			
			if(last=='A') {
                tb.deleteCharAt(tb.length() - 1);
			}else if(last=='B') {
                tb.deleteCharAt(tb.length() - 1);
                tb.reverse();
			}
		}
		
		
		System.out.println(tb.toString().equals(S)?1:0);
	}
}
