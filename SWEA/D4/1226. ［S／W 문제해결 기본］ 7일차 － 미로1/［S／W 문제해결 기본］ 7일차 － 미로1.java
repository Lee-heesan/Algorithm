import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{	
	static String [][] arr;
	static int [][] pos;
	static int [] dirX = {1,0,-1,0};
	static int [] dirY = {0,1,0,-1};
	static boolean [][]visited;
	static boolean isFind;
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		
		for(int i =1 ; i<=10;i++) {
			int T = Integer.parseInt(br.readLine());
			arr= new String[16][16];
			visited =new boolean[16][16];
			// 0 : 2(출발점) 1: 3(도착점)
			// 0 : x       1 : y
			pos = new int[2][2];
			isFind=false;
			
			
			for(int j =0; j<arr.length; j++) {
				String str = br.readLine();
				for(int k=0; k<arr[j].length; k++) {
					arr[j]=str.split("");
					if(arr[j][k].equals("2")) {
						pos[0][0]=k;
						pos[0][1]=j;
					}else if(arr[j][k].equals("3")) {
						pos[1][0]=k;
						pos[1][1]=j;
					}
				}
			}
			
			maze(pos[0][0],pos[0][1]);
			
			sb.append("#").append(i).append(" ").append(isFind?1:0).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean maze(int x , int y) {
		for(int i =0; i<4; i++) {
			int newX = x+dirX[i];
			int newY = y+dirY[i];
			if(newX==pos[1][0]&&newY==pos[1][1]) {
				isFind = true;
			}
			if(0<newX&&newX<16&&0<newY&&newY<16&&arr[newY][newX].equals("0")&&visited[newY][newX]==false) {
				visited[newY][newX]=true;
				maze(newX,newY);
				visited[newY][newX]=false;
			}
		}
		return false;
	}

}
