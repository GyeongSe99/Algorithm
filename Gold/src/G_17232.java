import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_17232 {

    private static int N, M, T, K, A, B;
    private static int[][] field, sum;

    private static void getInitSum() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + field[i][j];
            }
        }
    }
    
    private static int getAroundSum(int r, int c) {
        int r1 = Math.max(1, r - K);
        int c1 = Math.max(1, c - K);
        int r2 = Math.min(N, r + K);
        int c2 = Math.min(M, c + K);

        return sum[r2][c2] - sum[r1 - 1][c2] - sum[r2][c1 - 1] + sum[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        field = new int[N + 1][M + 1];
        sum = new int[N + 1][M + 1];

        // 초기 상태의 생명배열 입출력 받기
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                field[i][j] = s.charAt(j - 1) == '*' ? 1 : 0;
            }
        }

        // T시간 만큼의 변화 확인
        while (T --> 0) {
            // 주변의 생명 구간합
            getInitSum();

            // 생명의 변화
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int aroundSum = getAroundSum(i, j);

                    // 생명이 있는 상태일때
                    if (field[i][j] == 1) {
                        aroundSum--;
                        
                        if (aroundSum < A || aroundSum > B) {
                            field[i][j] = 0;
                        }
                    } else {    // 생명이 없는 상태일때
                        if (aroundSum > A && aroundSum <= B) {
                            field[i][j] = 1;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (field[i][j] == 1) {
                    sb.append('*');
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
