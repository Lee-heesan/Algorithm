
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
	
	static int [] dx = {0,1,-1,0};
	static int [] dy = {1,0,0,-1};
	static int [][] sum;
	static int [][] arr;
	static int min;
	static int N ; 
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i =0; i<T ; i++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int [N][N];
			sum=new int[N][N];
			
			for(int j=0;j<N;j++) {
                Arrays.fill(sum[j], Integer.MAX_VALUE);
            }
			
			for(int j=0; j<arr.length;j++) {
				String str = br.readLine();
				for(int k=0; k<str.length();k++) {
					arr[j][k]=str.charAt(k)-'0';
				}
			}
			sum[0][0]=0;
			
			road(0,0);
			sb.append("#").append(i+1).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static void road(int x, int y) {
		if(x==N-1&&y==N-1) {
			min = Math.min(min,sum[x][y]);
			return;
		}
		
		if(min<=sum[x][y]) {
		   	return;
		}
		
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
	        int ny=y+dy[i];
	        if(nx>=0&&ny>=0&&nx<N&&ny<N) {
	            int tmp=sum[x][y]+arr[nx][ny];
	            if(tmp<sum[nx][ny]) {        
	                sum[nx][ny]=tmp;
	                road(nx,ny);
	
	           }
	        }
		}
	
		
	}
}