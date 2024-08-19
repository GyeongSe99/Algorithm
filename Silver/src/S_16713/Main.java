package S_16713;

// si에서부터 ei까지 수열의 모두 ^연산한 값

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());    // 수열의 길이
        int Q = Integer.parseInt(st.nextToken());    // 쿼리의 개수

        st = new StringTokenizer(br.readLine());
        int[] num = new int[N + 1];
        int[] xor = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            xor[i] = xor[i - 1] ^ num[i];

        }

        int answer = 0;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            answer ^= xor[s - 1] ^ xor[e];
        }

        System.out.println(answer);


    }
}
