import java.io.*;
import java.util.*;

public class Solution {
    static final int max=1000000;
    static int n,answer;
    static int[] arr, dp;
    static boolean[] visit;
	public static void main(String [] args)throws IOException {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringBuilder sb=new StringBuilder();
	     

	     int T=Integer.parseInt(br.readLine());
	     
	     for(int tc=1;tc<=T;tc++){
	         n=Integer.parseInt(br.readLine());
	         arr=new int[n];
	         StringTokenizer st=new StringTokenizer(br.readLine());

	         dp =new int[max+1];
	         for(int i=0;i<n;i++){
	             arr[i]=Integer.parseInt(st.nextToken());
	             dp[arr[i]]=1;
	         }
	         Arrays.sort(arr);
	         visit=new boolean[max+1];
	         
	         answer=0;
	         for(int i=0;i<n;i++){
	             if(!visit[arr[i]]) {
	            	 go(arr[i]);
	             }
	         }
	         sb.append("#"+tc+" "+answer).append("\n");
	     }
	     System.out.print(sb);
	}
	    
	
	private static int go(int now){
		if(visit[now]) {
			return dp[now];
		}
		
	     for(int i=2;i*now<=arr[n-1];i++){
	         int next=now*i;
	         if(dp[next]!=0){
	             dp[now]=Math.max(dp[now],go(next)+1);
	         }
	     }

	     visit[now]=true;
	     answer=Math.max(answer,dp[now]);
	     return dp[now];
	}
}
