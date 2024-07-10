
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		while(true) {
			int A=sc.nextInt();
			int sum=0;
			ArrayList<Integer> L = new ArrayList<>();
			if(A!=-1) {
				for(int i=1; i<A;i++) {
					if(A%i==0) {
						L.add(i);
						sum+=i;
					}
				}
				if(sum==A) {
					System.out.print(A+" = ");
					for(int i=0; i<L.size();i++) {
						if(i!=L.size()-1) {
							System.out.print(L.get(i)+" + ");
						}else {
							System.out.print(L.get(i)+"\n");
						}
					}
				}
				else {
					System.out.println(A +" is NOT perfect.");
				}
			}else {
				break;
			}
		}

	}

}
