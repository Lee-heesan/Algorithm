
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int [] arr ;
	static int max = 0;
	static int result ;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N];
		int sum =0;
		
		for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Integer.max(max, arr[i]);
            sum += arr[i];
        }
		
	    int left = max;
	    int right = sum;

	    while (left <= right) {
            int mid = (left + right) / 2;
            
            if (M >= getWithdrawalCount(mid)) {
                result = mid;
                right = mid - 1;
                
            } else {
                left = mid + 1;
            }
        }
		
		System.out.println(result);

	}
	
	
	public static int getWithdrawalCount(int withdrawalAmount) {
			int count =1; 
			int money = withdrawalAmount;
			
			for(int i : arr) {
				money -= i;
				
				if(money<0) {
					count++;
					money = withdrawalAmount-i;
				}
			}
			
			return count ;
	}

}
