import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        int sum = 0;
        
        int f = 0;
        int e = 0;
        
        for(int i =0; i<num; i++){
            f= sc.nextInt();
            e= sc.nextInt();
            
            sum = f+e;
            
            System.out.println(sum);
        }
    }
}