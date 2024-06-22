import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
     
        int H = sc.nextInt();
        int M = sc.nextInt();
        
        int re = sc.nextInt();
        int plus = M+re;
        
        if(plus<60){
          	if(H>=24&&plus>0){
                  H=0;
             }
            System.out.println(H+" "+plus);
            
          }else if(plus>=60){
                H= H+(plus/60);
                plus=plus%60;
                if(H>=24){
                  H=H%24;
              	}
      
                System.out.println(H+" "+plus);
        }
    }
}
