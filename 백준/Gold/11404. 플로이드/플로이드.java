import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        long [][] D = new long[n+1][n+1];
        for(int i = 1; i<=n; i++){
            Arrays.fill(D[i],Long.MAX_VALUE/2);
            D[i][i]=0;
        }
        
        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            D[a][b] = Math.min(D[a][b],c);
        }
        
        for(int i =1; i<=n; i++){
            for(int k =1; k<=n; k++){
                for(int r =1; r<=n; r++){
                    D[k][r] = Math.min(D[k][r], D[k][i]+D[i][r] );
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<=n; i++){
            for(int j =1; j<=n; j++){
                if(D[i][j]==Long.MAX_VALUE/2){
                    sb.append(0+" ");
                    continue;                  
                }
                
                sb.append(D[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}