import java.util.Scanner;

public class Main{
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        
        for(int i =1; i<=A; i++){
            for(int k =0; k<i; k++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}