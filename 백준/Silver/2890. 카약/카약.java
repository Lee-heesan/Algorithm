import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char [][] map;
	static PriorityQueue<kayak> rank;
	static int [] result = new int[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		rank = new PriorityQueue<kayak>(new Comparator<kayak>() {

			@Override
			public int compare(kayak o1, kayak o2) {
				return o1.dis-o2.dis;
			}
		});
		
		for(int i =0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i =0; i<R; i++) {
			for(int j =C-2; j>0; j--) {
				if(map[i][j]!='.') {
					int num = map[i][j] - '0';
					int dis = (C - 2) - j;
					rank.add(new kayak(num,dis));
					break;
				}
			}
		}
		
		int ranking = 1;
		int prevDis = -1;
		
		while(!rank.isEmpty()) {
			kayak now = rank.poll();
			if (now.dis != prevDis) {  // 거리가 바뀌면 등수 증가
                prevDis = now.dis;
                result[now.num] = ranking;
                ranking++;
            } else {                   // 동점이면 같은 등수
                result[now.num] = ranking - 1;
            }
		}
		
		for(int i = 1; i<result.length; i++) {
			System.out.println(result[i]);
		}	
	}
	
	static class kayak{
		int num;
		int dis;
		
		
		public kayak(int num, int dis)
		{
			this.num = num;
			this.dis = dis;
		}
		
	}

}
