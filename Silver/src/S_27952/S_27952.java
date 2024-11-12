package S_27952;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_27952 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 대회까지 남은 일 수
        long X = Integer.parseInt(st.nextToken());    // 루틴 진행 시 -kg

        long[] cutline = new long[N + 1];
        long[] plus = new long[N + 1];
        long[] sum = new long[N + 1];
        long result = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            cutline[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            plus[i] = Long.parseLong(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + plus[i];

            if (sum[i] - cutline[i] < 0) {
                result = -1;
                break;
            }
        }

        if (result == -1) {
            System.out.println(result);
        } else {
            System.out.println((sum[N] - cutline[N]) / X);
        }

    }

}
