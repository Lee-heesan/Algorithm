
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
    static long[] tree; // 세그먼트 트리 배열
    static int size; // 트리의 크기
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        size = 1;
        while (size < n) {
        	size *= 2; // 트리 크기: n보다 큰 가장 작은 2의 거듭제곱
        }
        tree = new long[2 * size]; // 세그먼트 트리 배열 초기화

        // 리프 노드 입력 받기 2^k 승 부터
        for (int i = 0; i < n; i++) {
            tree[size + i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 초기화
        build();
        int leftNodeStartIndex = size -1;
        // 명령 처리
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // 값 업데이트
                update(b - 1, c);
            } else if (a == 2) { // 구간 합 계산
            	b = b + leftNodeStartIndex;
            	c = c + leftNodeStartIndex;
                sb.append(query(b,(int)c)).append("\n");
            }
        }

        System.out.println(sb);
    }

    // 세그먼트 트리 빌드
    private static void build() {
        for (int i = size - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    // 값 업데이트
    private static void update(int idx, long value) {
        idx += size; // 리프 노드 인덱스
        tree[idx] = value; // 값 갱신

        while (idx > 1) { // 부모 노드로 이동하며 갱신
            idx /= 2;
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
        }
    }

    // 구간 합 계산
    private static long query(int start, int end) {
        long partSum = 0;
        while(start<=end) {
        	if(start%2 ==1) {
        		partSum = partSum + tree[start];
        	}
        	if(end%2 ==0) {
        		partSum +=tree[end];
        	}
        	
        	start=(start+1)/2;
        	end = (end-1)/2;
        }
        return partSum;
    }
}
