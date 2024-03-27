package G_3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N, K, T, dIdx, r, c;

    static Queue<int[]> snake, command;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];

        // 사과 정보 초기화
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            board[r][c] = 1;
        }

        // 뱀의 처음 위치 초기화
        snake = new LinkedList<>();
        snake.add(new int[]{1, 1});

        // 방향 정보 초기화
        dIdx = 0;

        // 방향 전환
        T = Integer.parseInt(br.readLine());
        command = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            command.add(new int[]{Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)});
        }

        int time = 0;
        r = 1;
        c = 1;

        // 0초는 없어
        // 1초 부터 봐야함 -> time -> 1
        out : while (true) {
            time++;

            // 움직일 곳
            r += direction[dIdx][0];
            c += direction[dIdx][1];

            System.out.println("time = " + time + " [r : " + r + ", c : " + c + "]");

            if (1 <= r && N >= r && 1 <= c && N >= c) {
                int[] cur = {r, c};

                for (int[] body : snake) {
                    if (body[0] == cur[0] && body[1] == cur[1]){
                        break out;
                    }
                }

                snake.add(cur);

                // 사과를 먹었다면
                if (board[r][c] == 1) {
                    board[r][c] = 0;
                } else {
                    snake.poll();
                }
            } else {    // 부딪힘
                break;
            }

            // 방향 전환
            if (!command.isEmpty() && command.peek()[0] == time) {
                int[] curCmd = command.poll();

                if (curCmd[1] == 'D') {
                    dIdx = (dIdx + 1) % 4;
                } else {
                    dIdx = (dIdx - 1 + 4) % 4;
                }
            }

        }
        System.out.println(time);
    }
}
