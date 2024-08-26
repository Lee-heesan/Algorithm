import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int count,index;
		String Search;
		String str;
		
		for(int i=0 ; i<10; i++) {
			int T = sc.nextInt();
			count=0;
			index=0;
			
			Search = sc.next();
			str = sc.next();
			
			while((index = str.indexOf(Search,index))!=-1) {
				count++;
				index++;
			}
			
			sb.append("#").append(T).append(" "+count+"\n");
		}
		System.out.println(sb.toString());
	}

}