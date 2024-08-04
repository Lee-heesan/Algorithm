
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		String [] str = new String[T];
		int [] result = new int[T];
		
		
		for(int i=0; i<T; i++) {
			str[i] = sc.next();
			result[i]= findPatternLength(str[i]);
		}
		
		for(int i =0; i<T; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
		
	}
	
	
	public static int findPatternLength(String str) {
		int result=0;
		
		for(int strLength=1; strLength<=10;strLength++) {
			String pattern  = str.substring(0,strLength);
			boolean isPattern  = true;
			
			
			for(int j=strLength;strLength+j<30;j+=strLength) {
				if(!pattern.equals(str.substring(j,strLength+j))) {
					isPattern=false;
					break;
				}
			}
			
			if(isPattern ) {
				return strLength;
			}
		}
		return 0;
	}

}