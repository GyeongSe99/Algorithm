package G_20055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, K, front, rear, cycle;
    private static int[] belt;
    private static boolean[] containsRobot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2 * N];
        int idx = 0;
        boolean finished = false;
        containsRobot = new boolean[N];
        front = 0;
        rear = N - 1;

        while (true) {
            cycle++;

            // 1.
            rotateBelt();

            // 2.

        }
    }

    private static void rotateBelt() {
        front = (N + front) % N;
        rear = (N + rear) % N;
    }
}
