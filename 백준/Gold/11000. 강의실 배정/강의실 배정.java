import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<course> list = new ArrayList<course>();
		StringTokenizer st;
				
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list.add(new course(s, e));
		}
		
		Collections.sort(list, new Comparator<course>() {

			@Override
			public int compare(course o1, course o2) {
				return o1.start-o2.start;
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(list.get(0).end);
		for(int i = 1; i<N; i++) {
			if(pq.peek()<=list.get(i).start) {
				pq.poll();
			}
			
			pq.offer(list.get(i).end);
		}		
		
		System.out.println(pq.size());
	}
	
	static class course{
		int start;
		int end;
		
		public course(int start, int end) {
			this.end = end;
			this.start = start;
		}
	}
}
