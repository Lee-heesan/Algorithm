import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ; i<10; i++) {
			int dump = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			for(int j =0 ; j<dump;j++) {
				max = Collections.max(list);
			    min = Collections.min(list);
				
				
				list.set(list.indexOf(max), max-1);
				list.set(list.indexOf(min), min+1);
			}
			max= Collections.max(list);
			min = Collections.min(list);
			sb.append("#"+ (i+1) +" "+(max-min) +"\n");
		}
		System.out.println(sb);
	}

}
