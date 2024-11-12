package S_2630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2630 {

    private static int N, white, blue;
    private static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, N);

        System.out.println(white);
        System.out.println(blue);

    }

    private static void solution(int r, int c, int size) {
        if (size == 1) {
            if (arr[r][c] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != arr[r][c]) {
                    solution(r, c, size / 2);
                    solution(r, c + size / 2, size / 2);
                    solution(r + size / 2, c, size / 2);
                    solution(r + size / 2, c + size / 2, size / 2);
                    return;
                }
            }
        }

        if (arr[r][c] == 0) {
            white++;
        } else {
            blue++;
        }
    }

}
