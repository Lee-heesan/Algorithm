
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = 0;
		
		for(int i =0; i<10; i++) {
			N= Integer.parseInt(br.readLine());
			String [] str = br.readLine().split(" ");
			Queue<Integer> queue = new LinkedList<Integer>();
			
			for(int j=0; j<8;j++) {
				queue.add(Integer.parseInt(str[j]));
			}
			
			int count=1;
			
			while(true) {
				int num = queue.poll()-(count);
				
				if(num<=0) {
					queue.add(0);
					break;
				}else {
					queue.add(num);
				}
				
				count++;
				
				if(count==6) {
					count=1;
				}
			}
				
			sb.append("#"+N+" ");
			while (!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
