import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        
        int H = sc.nextInt();
        int M = sc.nextInt();
        int A = M-45;
        
          if(A>=0){
            System.out.println(H+" "+A);
          }else if(A<0){
                H=H-1;
                M=60+A;
                if(H<0){
                  H=23;
              	}
      
                System.out.println(H+" "+M);
        }
    }
}