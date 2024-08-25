import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
    
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T  = Integer.parseInt(br.readLine());  
        
        for (int i = 0; i < T; i++) {
            String og = br.readLine(); 
            int count = 0;
            char prev = '0';  
            
   
            for (int j = 0; j < og.length(); j++) {
                
                if (og.charAt(j) != prev) {
                    count++;
                    prev = og.charAt(j);  
                }
            }
            
            sb.append("#").append(i + 1).append(" ").append(count).append("\n");
        }
        System.out.print(sb.toString());
    }
}
