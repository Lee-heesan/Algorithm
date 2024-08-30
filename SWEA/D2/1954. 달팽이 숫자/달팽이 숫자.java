import java.util.Scanner;

class Solution
{
	static int [][] arr;
	static boolean [][] visited;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
	
		int T = sc.nextInt();
		
		for(int i = 0; i<T ; i++) {
			int N = sc.nextInt();
			arr = new int[N][N];
			visited = new boolean[N][N];
					
			clockSort(0,0,1,1);
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
	
	
	public static void clockSort(int x, int y,int count ,int as) {
		if (count > arr.length * arr.length) {
		    return;
		}

		
		
		switch (as) {
		case 1:
			while(arr.length>x&& !visited[y][x]) {
				arr[y][x]=count++;
				visited[y][x]=true;
				x++;
			}
			clockSort(x-1,y+1,count,as+1);
			break;
		case 2:
			while(arr.length>y&& !visited[y][x]) {
				arr[y][x]=count++;
				visited[y][x]=true;
				y++;
			}
			clockSort(x-1,y-1,count,as+1);
			break;
		case 3:
			while(0<=x&& !visited[y][x]) {
				arr[y][x]=count++;
				visited[y][x]=true;
				x--;
			}
			clockSort(x+1,y-1,count,as+1);
			break;
		case 4:
			while(y >= 0&&!visited[y][x]) {
				arr[y][x]=count++;
				visited[y][x]=true;
				y--;
			}
			clockSort(x+1,y+1,count,1);
			break;
		}

	}

}
