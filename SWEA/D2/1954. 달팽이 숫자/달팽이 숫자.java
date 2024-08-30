import java.util.Scanner;

class Solution
{
	static int [] dx = {1,0,-1,0};
	static int [] dy = {0,1,0,-1};

	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int i =0 ; i<T; i++) {
			int N = sc.nextInt();
			int [][] arr = new int[N][N];
			
			int hx = 0;
			int hy = 0;
			int d =0;
			
			for(int j=0; j<N*N;j++) {
				arr[hy][hx]=j+1;
				if(hx+dx[d]>=arr.length|| hy+dy[d]>=arr.length ||hy+dy[d]<0 || hx+dx[d]<0 || arr[hy+ dy[d]][hx+dx[d]]!=0) {
					d++;
					if(d>3) {
						d=0;
					}
				}
				hx = hx+ dx[d];
				hy = hy+ dy[d];
			}
			
			
			sb.append("#").append(i+1).append("\n");
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
				 sb.append(arr[j][k]+" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());

	}

}
