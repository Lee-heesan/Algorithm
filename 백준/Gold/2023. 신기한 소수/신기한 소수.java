import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		list = new ArrayList<Integer>();
		
		DFS(0,1);
		
		Collections.sort(list);
		
		for(int i : list) {
			sb.append(i+"\n");
		}
		
		System.out.println(sb);
	}
	
	public static void DFS(int num ,int index) {
		if(index>N) {			
			list.add(num);
			return;
		}
		
		
		for(int i = 1; i <=9; i++) {
			int tmp = num*10+i;
			boolean isTrue = true;
			
			if(tmp==1) {
				continue;
			}
			
			for(int j=2; j<tmp; j++) {
				if(tmp%j==0) {
					isTrue =false;
                    break;
				}
			}
			if(isTrue) {
				DFS(tmp,index+1);	
			}
		}

	}

}
