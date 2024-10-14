
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	    arr = new int[N];
		
	    StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		 // 삽입 정렬
        for (int i = 1; i < N; i++) {
            int key = arr[i]; 
            int j = i - 1;

           
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  
                j--;
            }
            arr[j + 1] = key;  
        }
		int sum = 0;
		
		for(int i : arr) {
			sum = sum + ((N--)*i);	
		}
		System.out.println(sum);

	}
	
	public static void swap(int i , int j) {
		int tmp = arr[i];
		arr[i]= arr[j];
		arr[j] = tmp;
	}

}
