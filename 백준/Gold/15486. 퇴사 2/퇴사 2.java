import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int date;
        int money;
        
        public Node(int date, int money) {
            this.date = date;
            this.money = money;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Node [] arr = new Node[N+2];
        long[] dp = new long[N + 2];  
        
        for(int i =1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            arr[i] = new Node(t,p);
        }
        
        long max = 0; 
        
        for (int i = 1; i <= N + 1; i++) {
            max = Math.max(max, dp[i]);
            
            if(i <= N) {
                int t = arr[i].date;
                int p = arr[i].money;
                
                if (i + t <= N + 1) {
                    dp[i + t] = Math.max(dp[i + t], max + p);
                }
            }
        }

        System.out.println(max);
    }
}