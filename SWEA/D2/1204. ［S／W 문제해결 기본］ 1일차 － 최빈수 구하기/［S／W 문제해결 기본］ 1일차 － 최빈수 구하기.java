import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T;i++) {
			String num = br.readLine();
			
			Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
			
			int a = 0;
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<1000; j++) {
				a = Integer.parseInt(st.nextToken());
				if(cnt.containsKey(a)) {
					cnt.put(a, cnt.get(a)+1);
				}else{
					cnt.put(a, 1);
				}
			}
			List<Integer> list = new ArrayList<Integer>(cnt.keySet());
			Collections.sort(list);
			
			int maxValue = Collections.max(cnt.values());
			
			int result=-1;
			
			for(int Key : cnt.keySet()) {
				if(cnt.get(Key)==maxValue) {
					result = Key;
				}
			}
			
			sb.append("#").append(num).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
