import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int [] R= {A,B,C};
        int max=0;
        int represent=0;
         if(A==B || A==C || B==C){
            for(int i =0; i < 1;i++){
                if(R[i]==R[i+1]||R[i]==R[i+2]){
                    max++;
                    represent=R[i];
                }
                if(R[i+1]==R[i+2]){
                	max++;
                    represent=R[i+1];
                }
            }
            if(max==2){
                max=10000+represent*1000;
            }else if(max==1){
                max=1000+represent*100;
            }
            System.out.println(max);
        }else{
            for(int i =0; i < R.length;i++){
                if(R[i]>max){
                    max=R[i];
                }
            }
            max=max*100;
            System.out.println(max);
        }
    }
}