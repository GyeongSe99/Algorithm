package AlgoTest_graph_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test3 {
    /*
     * 2일때 X번의 수련을 한다면 10일때 수련의 횟수는 34X-21
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            long N = Long.parseLong(br.readLine());

            // 나누어 떨어지지 않을땐 수련이 더 필요하다는 뜻이므로 1을 더해주어야 함.
            long answer = (N - 21) % 34 == 0 ? (N - 21)/34 : (N - 21)/34 + 1;
            System.out.println("#" + test_case + " " + answer);
        }

    }
}
