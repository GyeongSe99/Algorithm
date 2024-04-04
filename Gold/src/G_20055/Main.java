package G_20055;
// 컨베이어 벨트 위의 로봇

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int K;
    private static int front;
    private static int rear;
    private static int[] belt;
    private static boolean[] containsRobot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cycle = 0;
        int n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        N = n * 2;
        belt = new int[N];
        containsRobot = new boolean[N];
        front = 0;
        rear = n - 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            cycle++;

            // 1.
            rotateBelt();
            // 2.
            move();
            // 3.
            locateRobot();
            // 4.
            if (!checkDurability()) break;
        }

        System.out.println(cycle);
    }

    /** 1. 벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전한다.
     * 회전했을 경우 내리는 위치에 도달하면 그 즉시 내리므로 rear는 항상 false인 상태를 유지
     */
    private static void rotateBelt() {
        // 인덱스만 옮기면 된다.
        front = (N + front - 1) % N;
        rear = (N + rear - 1) % N;

        // 내리는 위치에 도달하면 그 즉시 내린다.
        containsRobot[rear] = false;
    }

    // 2. 로봇 움직이기
    // 1단계에서 REAR에 있는 로봇은 내려줬으므로 REAR는 항상 FALSE
    private static void move() {
        int cur = (N + rear - 1) % N;
        // 현재 보려는 곳이 맨앞에 도달하기 전까지
        while (cur != front) {
            int next = (cur + 1) % N;

            // 현재 보려는 자리에 로봇이 있다면
            if (containsRobot[cur]) {
                // 맨마지막에 있는 로봇이 아니고, 다음칸에 로봇이 없으며, 다음칸의 내구도가 0이상일 경우
                if (cur != rear && !containsRobot[next] && belt[next] > 0) {
                    // 다음칸으로 옮겨주고 해당 칸 비워두기
                    containsRobot[next] = true;
                    containsRobot[cur] = false;
                    // 옮겨간 칸이 마지막 칸이었을경우 바로 내려주기
                    if (next == rear) {
                        containsRobot[next] = false;
                    }
                    // 내구도 감소시켜주기
                    belt[next]--;
                }
            }
            cur = (N + cur - 1) % N;
            // cur이 front랑 같아지면 반복문을 돌지 않는데
            // front는 항상 로봇이 없기 때문에 끝내도 됨.
        }
    }

    // 3. 올리는 위치의 내구도가 0이 아니면 로봇 올리기
    private static void locateRobot() {
        if (belt[front] > 0) {
            containsRobot[front] = true;
            belt[front]--;
        }
    }

    // 4. 내구도가 0인 칸의 개수가 K개 이상이면 과정 종료
    private static boolean checkDurability() {
        int cnt = 0;
        for (int j : belt) {
            if (j <= 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
}
