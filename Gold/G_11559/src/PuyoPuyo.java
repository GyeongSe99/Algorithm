import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PuyoPuyo {
    public static char[][] board;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static Queue<int[]> queue;

    public static void main(String[] args) throws Exception {
        board = new char[12][6];
        queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 상대방의 블럭 받기
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = s.charAt(0);
            }
        }

        while (true) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != '.') {
                        char alpa = board[i][j];
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }

    }
}
