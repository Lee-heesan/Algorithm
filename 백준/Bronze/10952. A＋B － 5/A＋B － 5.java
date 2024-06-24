import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer St;
        int A;
        int B;
        
        do{
           St = new StringTokenizer(br.readLine()," ");
           A=Integer.parseInt(St.nextToken());
           B=Integer.parseInt(St.nextToken());
           if(A==0||B==0){
               break;
           }
           bw.write(A+B+"\n");
           
        }while(A!=0||B!=0);
        br.close();
        bw.flush();
        bw.close();
    }
}