
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static Deque<Node> deque=new LinkedList<Node>();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!deque.isEmpty() && deque.getLast().value > now) {
				deque.removeLast();
			}
			
			deque.addLast(new Node(i,now));
			
			if(i-deque.getFirst().index>=L) {
				deque.removeFirst();
			}
			sb.append(deque.getFirst().value +" ");
		}
		
		System.out.println(sb);
	}
	
	static class Node {
		public int index;
		public int value;
		
		Node(int index, int value){
			this.index = index;
			this.value = value;
		}
	}

}
