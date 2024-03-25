package B_1268;
// https://www.acmicpc.net/problem/1268
// 임시반장 정하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; st.hasMoreTokens(); j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;

        // 반
        for (int i = 0; i < N; i++) {   // 사람2
            int cnt = 0;

            for (int j = 0; j < N; j++) {   // 사람1
                for (int k = 0; k < 5; k++) {   // 학년
                    if (board[i][k] == board[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt > max) {
                max = cnt;
                answer = i;
            }

        }

        System.out.println(answer + 1);
    }
}
