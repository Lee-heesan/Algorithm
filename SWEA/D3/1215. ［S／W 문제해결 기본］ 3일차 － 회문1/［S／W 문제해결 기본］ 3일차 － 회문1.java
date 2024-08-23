
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
{
		Scanner sc = new Scanner(System.in);
		StringBuffer sb= new StringBuffer();
		
		int length = 0;
		String [] str = new String [8];
		
		for(int i =0; i<10;i++) {
			length = sc.nextInt();
			int count = 0;
			
			
			//가로 입력 후 검사
			for(int j=0; j<str.length;j++) {
				str[j]=sc.next();
				count +=palidrome(str[j],length);
			}
			
			//세로 검사
			for(int j=0; j<str.length;j++) {
				String ing = "";
				for(int k=0;k<str.length;k++) {
					ing += str[k].charAt(j);
				}
				count +=palidrome(ing,length);
			}

			sb.append("#"+(i+1)+" "+count+"\n");
		}
		System.out.println(sb.toString());
	}
	
	
	public static int palidrome (String str,int length) {
		int count = 0;
		for(int k=0;k<=str.length()-length;k++) {
			String str1 = str.substring(k,k+length);
			StringBuffer sb = new StringBuffer(str1);
			String str2 = sb.reverse().toString();
			
			if(str1.equals(str2)){
				count++;
			}
		}
		
		return count;
	}

}