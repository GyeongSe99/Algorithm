package S_1730;
// 판화

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final char[] dc = {'U', 'D', 'L', 'R'};
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.';
            }
        }
        String command = br.readLine();

        int r = 0;
        int c = 0;

        board: for (int i = 0; i < command.length(); i++) {
            char cm = command.toCharArray()[i];
            char shape = '.';
            int nr = r;
            int nc = c;

            for (int j = 0; j < 4; j++) {
                if (cm == dc[j]) {
                    nr += d[j][0];
                    nc += d[j][1];

                    // 범위를 벗어났다면 무시하고 다음 명령 수행
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N){
                        continue board;
                    }

                    if (j <= 1) {
                        shape = '|';
                    } else {
                        shape = '-';
                    }

                    break;
                }
            }

            // 현재 자리 확인하고 현재 그려야하는 선이 이전에 그린 선과 모양이 다를때만 +로 표시
            draw(r, c, shape);
            draw(nr, nc, shape);

            r = nr;
            c = nc;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void draw(int r, int c, char shape) {
        if (board[r][c] == '.') {
            board[r][c] = shape;
        } else {
            if (board[r][c] != shape) {
                board[r][c] = '+';
            }
        }
    }
}
