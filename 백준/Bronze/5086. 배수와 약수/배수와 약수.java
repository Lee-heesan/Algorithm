import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		ArrayList<String> L = new ArrayList<>();
		while(true) {
			st= new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(A!=0 && B!=0) {
				if(B%A==0){//약수
					L.add("factor");
				}else if(A%B==0) { //배수
					L.add("multiple");
				}else { //나머지
					L.add("neither");
				}
			}else {
				break;
			}
		}
		
		for(int i=0; i<L.size();i++) {
			System.out.println(L.get(i));
		}
	}

}
