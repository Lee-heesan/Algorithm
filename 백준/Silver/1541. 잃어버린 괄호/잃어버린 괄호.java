
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static String [] minusEX;
	static Queue<Integer> last;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		minusEX = str.split("\\-");

		last = new LinkedList<Integer>();
		
		for(int i =0; i<minusEX.length;i++) {
			if(!minusEX[i].contains("+")) {
				last.add(Integer.parseInt(minusEX[i]));
				continue;
			}
			String [] plusEX = minusEX[i].split("\\+");
			int sum=0;
			for(int j=0; j<plusEX.length;j++) {
				sum+= Integer.parseInt(plusEX[j]);
			}
			last.add(sum);
		}

		int result = last.remove();
		while(!last.isEmpty()) {
			result -= last.remove();
		}
		System.out.println(result);
		
	}

}
