import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution
{
	 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] prices = new int[N];
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                prices[j] = Integer.parseInt(st.nextToken());
            }

            sb.append("#").append(i + 1).append(" ").append(maxProfit(prices)).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static long maxProfit(int[] prices) {
        int n = prices.length;
        long maxProfit = 0;
        int maxPrice = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] < maxPrice) {
                maxProfit += (maxPrice - prices[i]);
            } else {
                maxPrice = prices[i];
            }
        }

        return maxProfit;
    }
}