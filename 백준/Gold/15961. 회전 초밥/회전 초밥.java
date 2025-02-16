import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,d,k,c;
	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		int N = Integer.parseInt(st.nextToken()); // 접시 개수
	    int d = Integer.parseInt(st.nextToken()); // 초밥 종류
	    int k = Integer.parseInt(st.nextToken()); // 연속해서 먹을 접시 개수
	    int c = Integer.parseInt(st.nextToken()); // 쿠폰 초밥
	    
	    int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        
        
        int[] count = new int[d + 1];
        int uniqueCount = 0; 
        
        
        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) {
            	uniqueCount++; // 새로운 종류 추가
            }
            count[sushi[i]]++;
        }
        
        int maxTypes = uniqueCount;
        if (count[c] == 0) {
        	maxTypes++;
        }
        
        for (int i = 1; i < N; i++) {
            //  맨 앞 초밥 제거
            int removeIdx = i - 1;
            count[sushi[removeIdx]]--;
            if (count[sushi[removeIdx]] == 0) uniqueCount--; // 더 이상 없는 경우 종류 감소

            //  새 초밥 추가
            int addIdx = (i + k - 1) % N; // 원형 배열 처리
            if (count[sushi[addIdx]] == 0) uniqueCount++;
            count[sushi[addIdx]]++;

            // 쿠폰 초밥 포함 여부 확인
            int currentMax = (count[c] == 0) ? uniqueCount + 1 : uniqueCount;
            maxTypes = Math.max(maxTypes, currentMax);
        }

        System.out.println(maxTypes);
	}
}
