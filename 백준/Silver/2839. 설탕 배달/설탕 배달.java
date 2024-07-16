import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int kg = sc.nextInt();
		int count = 0;
		
		while(kg>0) {
			if(kg%5==0&&kg>=5) {
				kg-=5;
				count++;
	
			}else if (kg%3==0&&kg>=3) {
				kg-=3;
				count++;
			}else if (kg>5) {
				kg-=5;
				count++;
			}else if (kg<5&&kg%3!=0||kg%5!=0){
				count=-1;
				break;
			}else if(kg==0) {
				break;
			}
		}
		System.out.println(count);
	}

}
