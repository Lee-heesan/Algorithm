import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int count = 0;
	static int N,K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(arr,0,arr.length-1);
		
		if(count<K) {
			System.out.println(-1);
		}
	}
	
	public static void quickSort(int [] arr, int start, int end) {
		 if (start < end) {
	            int pivot = partition(arr, start, end);
	            quickSort(arr, start, pivot-1); 
	            quickSort(arr, pivot+1, end); 
	    }
	}
	
	public static int partition(int [] arr, int p, int r) {
		int pivot = arr[r];
		int idx = p-1;
		
		for(int i = p; i<r; i++) {
			if(arr[i] <= pivot) {
				idx++;
				swap(arr,idx,i);
			}
		}
		
		if (idx+1 != r) {
            swap(arr, idx+1, r);
        }

        return idx+1;
	}
	
	public static void swap(int [] arr,int a,int b) {
		int num = arr[a];
        arr[a] = arr[b];
        arr[b] = num;

        count++;
        if (count == K) {
            System.out.print(arr[a] + " " + arr[b]);
        }
    }
}
