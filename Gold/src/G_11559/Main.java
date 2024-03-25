package G_11559;

/*
뿌요뿌요 : https://www.acmicpc.net/problem/11559
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static char[][] board;
    public static boolean[][] visited;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static Queue<int[]> queue;
    public static ArrayList<int[]> temp;
    public static int cnt = 0;


    public static void main(String[] args) throws Exception {
        board = new char[12][6];
        visited = new boolean[12][6];
        queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 상대방의 블럭 받기
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = s.charAt(j);
            }
        }

//        printBoard();

        while (true) {
            boolean isChanged = false;
            visited = new boolean[12][6];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != '.') {
                        char alpa = board[i][j];
                        temp = new ArrayList<>();

                        queue.add(new int[]{i, j});

                        // bfs 탐색
                        while (!queue.isEmpty()) {
                            int[] p = queue.poll();
                            visited[p[0]][p[1]] = true;
                            temp.add(p);

                            for (int k = 0; k < 4; k++) {
                                int nr = p[0] + dr[k];
                                int nc = p[1] + dc[k];

                                if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && alpa == board[nr][nc] && !visited[nr][nc]) {
                                    queue.add(new int[]{nr, nc});
                                }
                            }
                        }

                        // 결과 사이즈가 4이상일때만 블럭 없애기
                        if (temp.size() >= 4) {
                            if (!isChanged) {
                                isChanged = true;
                                cnt++;
                            }
                            for (int[] cur : temp) {
                                board[cur[0]][cur[1]] = '.';
                            }
                        }
                    }
                }
            }

            if (!isChanged) {
                break;
            }

            // 중력 적용
            doGravity();
//            printBoard();
        }

        System.out.println(cnt);

    }

    private static void doGravity() {
        Queue<Character> q = new LinkedList<>();
        for (int c = 0; c < 6; c++) {
            for (int r = 11; r >= 0; r--) {
                if (board[r][c] != '.') {
                    q.add(board[r][c]);
                    board[r][c] = '.';
                }
            }

            int size = q.size();

            for (int i = 0; i < size; i++) {
                char cur;
                if (!q.isEmpty()) {
                    cur = q.poll();
                    board[11 - i][c] = cur;
                }
            }
        }
    }

//    private static void printBoard() {
//        System.out.println("----------------------------------------");
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("--------------------------------------------");
//    }
}
