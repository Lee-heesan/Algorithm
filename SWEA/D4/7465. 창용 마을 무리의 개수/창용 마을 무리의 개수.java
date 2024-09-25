import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	 static int [] arr;
	public static void main(String args[])throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int i = 1 ; i <= T; i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int N = Integer.parseInt(st.nextToken());
    		int M = Integer.parseInt(st.nextToken());
    		
    		arr = new int [N+1];
    		
    		for(int j=1; j<N+1;j++) {
    			arr[j]=j;
    		}
    		
    		
    		for(int k=0; k<M;k++) {
    			st=new StringTokenizer(br.readLine()," ");
    			int from = Integer.parseInt(st.nextToken());
    			int to = Integer.parseInt(st.nextToken());
    			unionParent(from,to);
    		}
    		
    		
    		int count = 0 ;
    		for(int k =1; k<N+1;k++) {
    			if(arr[k]==k) {
    				count++;
    			}
    		}

    		sb.append("#").append(i).append(" ").append(count).append("\n");
    	}
    	System.out.println(sb.toString());
    }
	public static void unionParent(int from , int to) {
		int x = getParent(from);
		int y = getParent(to);
		
		if(x>y) {
			arr[x]=y;
		}else {
			arr[y]=x;
		}
	}
	
	
	public static int getParent(int A) {
		if(arr[A]==A) {
			return A;
		}
		return getParent(arr[A]);
	}
}

