import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int N = Integer.parseInt(br.readLine());
            String num[] = new String[N];
            for(int j = 0; j < N; j++){
                num[j] = br.readLine();
            }
            find(num);
        }

        System.out.println(sb);

    }

    public static void find(String num[]){
        Arrays.sort(num);

        for(int i = 0; i < num.length - 1; i++){
            if(num[i+1].startsWith(num[i])){
                sb.append("NO");
                sb.append("\n");
                return;
            }
        }
        sb.append("YES");
        sb.append("\n");
    }
}
