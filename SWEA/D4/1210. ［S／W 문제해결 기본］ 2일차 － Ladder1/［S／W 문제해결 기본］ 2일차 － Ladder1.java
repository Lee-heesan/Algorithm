import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int [] dirX  = {-1,1,0};
	static int [] dirY  = {0,0,-1};
	static int [][] arr = new int[101][101];
	static boolean [][] visited ;

	public static void main(String args[]) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		
		for(int i  = 1; i<=10; i++) {
			int T = Integer.parseInt(br.readLine());
			
			
			// 0 : Y , 1 : X
			int [] des = new int[2];
			visited = new boolean [101][101];
			
			for(int j=1; j<=100; j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k=1; k<=100; k++) {
					int num = Integer.parseInt(st.nextToken());
					arr[j][k]=num;
					if(num==2) {
						des[0]=j;
						des[1]=k; 
					}
				}
			}
			
			int answer = dir(des[1],des[0]);
			
			sb.append("#").append(T).append(" ").append(answer-1).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int dir(int x , int y) {
		if(y==1) {
			return x;
		}
		
		for(int i = 0 ; i<3; i++) {
			int tmpX = x+ dirX[i];
			int tmpY = y+ dirY[i];
			if(tmpX<101&&!visited[tmpY][tmpX]&&arr[tmpY][tmpX]==1) {
				visited[tmpY][tmpX]=true;
				return dir(tmpX,tmpY);
			}
		}
		return 0;
	}

}
