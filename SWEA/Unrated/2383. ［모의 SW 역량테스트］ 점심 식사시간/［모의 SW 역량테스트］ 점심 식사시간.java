import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    static int T, N, peopleCnt, minTime;
    static int[][] map;
	static boolean[] visited;
    static List<Point> stairs = new ArrayList<>();
    static List<Point> people = new ArrayList<>();
    
    static class Person implements Comparable<Person>{
        int x, y, dis;

        public Person(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
        
        @Override
		public int compareTo(Person o) {
			return this.dis - o.dis;
		}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            stairs = new ArrayList<>();
            people = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    
                    if (map[i][j] == 1) {
                        people.add(new Point(j, i));  
                    } else if (map[i][j] > 1) {
                        stairs.add(new Point(j, i));  
                    }
                }
            }
            
            peopleCnt = people.size();
            minTime = Integer.MAX_VALUE;
            visited = new boolean[peopleCnt];
            
            assignPeopleToStairs(0);
            
            sb.append("#" + tc + " " + minTime).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    
    static void assignPeopleToStairs(int idx) {
        if (idx == peopleCnt) {
        	
            List<Person> group1 = new ArrayList<>();
            List<Person> group2 = new ArrayList<>();
            
            for (int i = 0; i < peopleCnt; i++) {
                int x = people.get(i).x;
                int y = people.get(i).y;
                int dis;
                
                if (visited[i]) {
                    dis = Math.abs(x - stairs.get(0).x) + Math.abs(y - stairs.get(0).y);
                    group1.add(new Person(x, y, dis));
                } else {
                    dis = Math.abs(x - stairs.get(1).x) + Math.abs(y - stairs.get(1).y);
                    group2.add(new Person(x, y, dis));
                }
            }
            
            Collections.sort(group1);
			Collections.sort(group2);
			
            minTime = Math.min(minTime, Math.max(calculateTime(0, group1), calculateTime(1, group2)));
            return;
        }
        
        visited[idx] = true;
        assignPeopleToStairs(idx + 1);
        
        visited[idx] = false;
        assignPeopleToStairs(idx + 1);
    }
    
    
    static int calculateTime(int stairNum, List<Person> group) {
        int time = 0;
        int stairTime = map[stairs.get(stairNum).y][stairs.get(stairNum).x];
        
        for (int i = 0; i < group.size(); i++) {
            if (i < 3) {
            	time = group.get(i).dis + 1 + stairTime;
            } else {
            	if(group.get(i-3).dis + 1 + stairTime <= group.get(i).dis) {
					time = group.get(i).dis + 1 + stairTime;
            	}else {
					time = group.get(i-3).dis + 1 + stairTime + stairTime;	
				}
			}
        }
        
        return time;
    }
}