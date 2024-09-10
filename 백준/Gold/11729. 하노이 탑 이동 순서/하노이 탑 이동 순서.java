import java.util.Scanner;

public class Main {

	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		sb.append((int)Math.pow(2, N)-1).append("\n");
		
		Hanoi(N,1,2,3);
		System.out.println(sb.toString());
		
	}
	
	public static void Hanoi(int N, int start , int mid , int to) {

		if(N==1) {
			sb.append(start + " "+ to+"\n");
            return;
		}
		
		// 1. N-1개의 디스크를 출발 기둥에서 중간 기둥으로 옮기기
        Hanoi(N - 1, start, to, mid);

        // 2. 가장 큰 디스크를 출발 기둥에서 목표 기둥으로 옮기기
        sb.append(start + " " + to + "\n");

        // 3. N-1개의 디스크를 중간 기둥에서 목표 기둥으로 옮기기
        Hanoi(N - 1, mid, start, to);
		
	}

}
