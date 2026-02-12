import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		// 1) 전체 a 개수
		 int k = 0;
	     for (int i = 0; i < arr.length; i++) {
	         if (arr[i] == 'a') {
	        	 k++;
	         }
	     }
	     
	    // a가 0개거나 전부 a면 바꿀 필요 없음
	    if (k == 0 || k == arr.length) {
	        System.out.println(0);
	        return;
	    }
	    
	    int bCnt = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] == 'b') {
            	bCnt++;
            }
        }
		
        int ans = bCnt;
        
        // 슬라이딩 윈도우
        for (int start = 1; start < arr.length; start++) {
            // 윈도우에서 빠지는 문자
            if (arr[start-1] == 'b') {
            	bCnt--;
            }

            // 윈도우에 새로 들어오는 문자 (원형)
            int end = (start + k - 1) % arr.length;
            if (arr[end] == 'b') {
            	bCnt++;
            }

            ans = Math.min(ans, bCnt);
        }

        System.out.println(ans);
	}
}
