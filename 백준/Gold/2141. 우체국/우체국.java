import java.io.*;
import java.util.Arrays;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		node [] arr = new node [N];
		long total = 0;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int village = Integer.parseInt(st.nextToken());
			int human = Integer.parseInt(st.nextToken());
			arr[i] = new node(village,human);
			total += human;
		}
				
		 Arrays.sort(arr, Comparator.comparingLong(o -> o.num));

	     long target = (total + 1) / 2;
	     long prefix = 0;
	     
	     for (node n : arr) {
	            prefix += n.people;
	            if (prefix >= target) {
	                System.out.println(n.num);
	                return;
	            }
	        }
	}
	
	static class node{
		long num;
		long people;
		
		public node(long num, long people) {
			this.num = num;
			this.people = people;
		}
	}
}
