import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<10;i++) {
			int length = Integer.parseInt(br.readLine());
			Map<Integer ,ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
			int count = 0;
			
			//값 넣기
			for(int j =0;j<100;j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k=0;k<100;k++) {
					int num =Integer.parseInt(st.nextToken());
					if(num==0) {
						continue;
					}else {
						ArrayList<Integer> list = map.get(k);
						if(list==null) {
							list=new ArrayList<Integer>();
							map.put(k, list);
						}
						map.get(k).add(num);
					}
				}
			}
			
			//교착 상태 출력
			for(int j=0;j<100;j++) {
				if(map.get(j).isEmpty()) {
					continue;
				}
				
				boolean isRed = false;
				for(int k =0; k<map.get(j).size();k++){
					if(map.get(j).get(k)==1) {
						isRed = true;
					}else if(map.get(j).get(k)==2&&isRed) {
						count++;
						isRed=false;
					}
				}
			}
			
			sb.append("#").append(i+1).append(" "+count+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
