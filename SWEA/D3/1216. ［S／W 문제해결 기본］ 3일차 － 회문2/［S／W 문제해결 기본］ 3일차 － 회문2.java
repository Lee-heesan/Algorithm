import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	static String[] arr;
	static long max;
	static StringBuilder sb= new StringBuilder();
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=10; i++) {
			int T = Integer.parseInt(br.readLine());
			
			arr = new String[100];
			max = 1;
			
			//가로
			for(int j=0; j<100; j++) {
				String str = br.readLine();
				arr[j]=str;
				palindrome(str, 100);
			}
			
			for(int j =0; j<100; j++) {
				String ing = "";
                for(int k=0;k<arr.length;k++) {
                    ing += arr[k].charAt(j);
                }
                palindrome(ing,100);
			}
			
			System.out.println("#"+T+" "+max);
		}
		
	}
	
	public static void palindrome(String str ,int length) {
		int st = 0;
		String tmp1 = "";
		String tmp2 = "";
		while(length>1||length>max) {
			tmp1 = str.substring(st,st+length);
			StringBuffer sb = new StringBuffer(tmp1);
			tmp2 = sb.reverse().toString();
			
			if(tmp1.equals(tmp2)) {
				max = Math.max(max, length);
				break;
			}
			
			st++;
			if(st+length>100) {
				st=0;
				length--;	
			}
		}
		
	}

}
