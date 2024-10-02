import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		
		int T = sc.nextInt();
		for(int i = 1; i<=T; i++) {
			int N = sc.nextInt();
			sb.append("#").append(i).append("\n");
			int [][] arr = new int[N][N+1];
			arr[0][1]=1;
			sb.append(arr[0][1]+"\n");
			for(int j = 1; j<N; j++) {
				for(int k=1; k<arr[j].length;k++) {
					arr[j][k] = arr[j-1][k-1]+arr[j-1][k];
					if(arr[j][k]!=0) {
						sb.append(arr[j][k]+" ");
					}
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());

	}

}
