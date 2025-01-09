import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_14889 {
    private static int N, min;
    private static int[][] map;
    private static int[] teamA;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        map = new int[N][N];
        teamA = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        select(0, 0);

        System.out.println(min);
    }

    private static void select(int idx, int count){
        if (count == N/2) {
            int scoreA = 0;
            int scoreB = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (teamA[i] == 1 && teamA[j] == 1) {
                        scoreA += map[i][j];
                        scoreA += map[j][i];
                    } else if (teamA[i] == 0 && teamA[j] == 0) {
                        scoreB += map[i][j];
                        scoreB += map[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(scoreA-scoreB));
            return;
        }

        for (int i = idx; i < N; i++) {
            if (teamA[i] != 1) {
                teamA[i] = 1;
                select(i + 1, count + 1);
                teamA[i] = 0;
            }
        }
    }
}
