
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		List<Integer> list = new LinkedList<Integer>();
		
		while(num > 0) {
			list.add(num%10);
			num=num/10;
		}
		int size = list.size();
		for(int i = 0; i<size;i++) {
			int max = Integer.MIN_VALUE;
			for(int j : list) {
				max = Math.max(max, j);
			}
			sb.append(max); 
			list.remove(list.indexOf(max));
		}
		System.out.println(sb.toString());
	}

}
