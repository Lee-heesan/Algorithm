import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int [][] arr = new int [N][N];
			for(int j =0 ; j<N; j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k=0;k<N;k++) {
					arr[j][k]=Integer.parseInt(st.nextToken());
				}
			}
			sb.append(calculator(arr,N)+"\n");
		}
		System.out.println(sb);
		
	}
	public static int calculator(int [][] arr,int N) {
		int operations = 0;
        
        for (int i = N - 1; i > 0; i--) {
            if (arr[0][i] != i + 1) {
                operations++;
                transpose(arr, i + 1);
            }
        }
        
        return operations;
		
	}
	
	public static void transpose(int [][] arr, int size) {
		for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
	}

}