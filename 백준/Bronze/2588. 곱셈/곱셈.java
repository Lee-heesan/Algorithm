import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int A = sc.nextInt();
    int B = sc.nextInt();
      
    int Q = A*(B%10);
    int W = A*((B%100)/10);
    int E = A*(B/100);
    int R = A*B;
      
    System.out.println(Q);
      System.out.println(W);
      System.out.println(E);
      System.out.println(R);
  }
}

