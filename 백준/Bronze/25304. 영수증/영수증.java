import java.util.*;

public class Main{
    public static void main(String [] args){
         Scanner sc = new Scanner(System.in);
        
         int sum = sc.nextInt();
         int count = sc.nextInt();
         
         int pr_price;
         int pr_count;   
         int pr_sum=0;
        
        for(int i=0; i<count; i++){
            pr_price = sc.nextInt();
            pr_count = sc.nextInt();
            
            pr_sum = pr_sum+ (pr_price*pr_count) ;
        }
        
        
       if(pr_sum==sum){
           System.out.println("Yes");
       }else{
           
           System.out.println("No");
       }
        
    }
}