// https://www.acmicpc.net/problem/15683

package G_15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, maxArea;
    static int[][] board;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        // 판 만들기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int temp = 0;

        printBoard();

        // 일단 dfs에 안넣어줘도 되는 5번 감시 카메라 부터 확인하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 5번 감시 카메라를 찾으면 -1(CCTV 안전지대)로 바꾸어주기

                if (board[i][j] == 5) {

                    for (int d = 0; d < dr.length; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                            // 6은 벽이기 때문에 해당방향으로 더이상 나아갈 수 없으므로
                            // 반복문 break후 다른 방향 탐색
                            if (board[nr][nc] == 6) {
                                break;
                            }

                            // 6이 아니라면 범위를 벗어나지 않을때까지 -1(CCTV)로 바꾸어 주기
                            // 6외의 다른 숫자는 CCTV인데 통과할 수 있으므로 그냥 넘어가면 됨
                            if (board[nr][nc] == 0) {
                                board[nr][nc] = -1;
                                temp++;
                            }

                            // 같은 방향으로 쭉 나아가기
                            nr += dr[d];
                            nc += dc[d];
                        }
                    }
                }
            }
        }

        printBoard();



    }

    static void printBoard() {
        System.out.println("----------------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != -1) {
                    System.out.print(" ");
                }
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
