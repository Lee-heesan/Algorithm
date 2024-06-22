import java.util.Scanner;
    
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    
    int First = (A+B)%C;
    int Second = ((A%C) + (B%C))%C;   
    System.out.println(First);
    System.out.println(Second);
      
    First = (A*B)%C;
    Second = ((A%C) * (B%C))%C;   
    System.out.println(First);
    System.out.println(Second); 
  }
}

