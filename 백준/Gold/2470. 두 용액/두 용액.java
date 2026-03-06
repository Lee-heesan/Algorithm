import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

       int left = 0;
       int right = N-1;
       
       int ansL = arr[left];
       int ansR = arr[right];
       
       int result = Math.abs(arr[left] + arr[right]);
       
       while(left<right) {
    	   int nowL = arr[left];
    	   int nowR = arr[right];
    	   int nowResult = Math.abs(nowL+nowR);
    	   
    	   if(nowResult<result) {
    		   result = nowResult;
    		   ansL = nowL;
    		   ansR = nowR;
    	   }
    	   
    	   if(nowL+nowR>0) {
    		   right--;
    	   }else if(nowL+nowR<0) {
    		   left++;
    	   }else {
    		   break;
    	   }
       }
       
       System.out.println(ansL+" "+ansR);
    }
}