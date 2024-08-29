import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전체 가로세로 크기가 100*100
// 색종이 10*10

public class S_2563 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        boolean[][] paper = new boolean[101][101];

        int sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int j = r; j < r + 10; j++) {
                for (int k = c; k < c + 10; k++) {
                    if (!paper[j][k]) {
                        paper[j][k] = true;
                        sum++;
                    }
                }
            }
        }

        System.out.println(sum);
    }

}
