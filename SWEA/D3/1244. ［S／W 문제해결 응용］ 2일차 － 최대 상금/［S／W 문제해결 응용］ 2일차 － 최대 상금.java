import java.util.Scanner;

class Solution
{
	static int N = 0;
	static int max = 0;
	static int [] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int i=0 ; i<T ; i++) {
			String str = sc.next();
		    N = sc.nextInt();
			arr = new int[str.length()];
			
			for(int j=0; j<str.length();j++) {
				arr[j] = str.charAt(j)-'0';
			}
			if(arr.length < N) {	
            	N = arr.length;	
            }
			
			DFS(0,0);
			sb.append(("#"+(i+1)+" "+max+"\n"));
			max=0;
		}
		
		System.out.print(sb);
	}
	
	static void DFS(int start, int depth) {
		if(depth == N) {
			int result=0;
			for(int i=0 ; i<arr.length;i++) {
				result += (Math.pow(10,i)*arr[arr.length-i-1]);
			}
			max = Math.max(max, result);
			
			return;
		}
		
		for(int i =0 ; i <arr.length; i++) {
			for(int j =i+1 ; j<arr.length; j++) {
				swap(i,j);
				DFS(i,depth+1);
				swap(i,j);
			}
		}
	}
	
	static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
