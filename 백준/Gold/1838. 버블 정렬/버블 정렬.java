import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class NUM {
		int index;
		int number;
		
		public NUM(int index, int number) {
			this.index = index;
			this.number = number;
		}
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<NUM> pq = new PriorityQueue<NUM>(new Comparator<NUM>() {

			@Override
			public int compare(NUM o1, NUM o2) {
				return o1.number-o2.number;
			}
		});
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pq.add(new NUM(i, Integer.parseInt(st.nextToken())));
		}
		
		int nowIndex =  0;
		int maxDis = -1;
		while(!pq.isEmpty()) {
			NUM NUMNow = pq.poll();
			
			if(maxDis<NUMNow.index-nowIndex) {
				maxDis = NUMNow.index-nowIndex;
			}
			nowIndex++;
		}
		
		System.out.print(maxDis);
	}
}
