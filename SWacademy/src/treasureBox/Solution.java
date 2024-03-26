package treasureBox;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static char[] nums;
    static int T, N, K, interval, max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            // 1B3 B3B 81F 75E
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            nums = br.readLine().toCharArray();

            int lIdx = 0;
            int rIdx = N - 1;

            interval = N / 4;

            for (int i = 0; i < N; i++) {
                int l = lIdx;

                // 4번 돌리는 횟수 카운트
                int roteCnt = 4;

                while (roteCnt > 0) {
                    StringBuilder sb = new StringBuilder();
                    // 글자 개수
                    int cnt = interval;

                    while (cnt > 0) {
                        sb.append(nums[l]);
                        l = (l + 1) % N;
                        cnt--;
                    }

                    // 10진수로 바꾸기
                    int decimalNumber = Integer.parseInt(sb.toString(), 16);

                    max = Math.max(decimalNumber, max);

                    roteCnt--;
                }

                lIdx = (lIdx + 1) % N;
                rIdx = (rIdx + 1) % N;
            }
        }
    }
}
