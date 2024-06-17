package S_2840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        boolean isLuckyWheel = true;

        char[] wheel = new char[size];
        Arrays.fill(wheel, '?');

        out: while (N > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            idx = (idx + n) % size;

            // 중복 체크
            for (int i = 0; i < wheel.length; i++) {
                if (wheel[i] == c && i != idx) {
                    isLuckyWheel = false;
                    break out;
                }
            }

            if (wheel[idx] == '?') {
                wheel[idx] = c;
                N--;
                continue;
            }

            // '?'이 아니라면 입력되어있는 글자와 새로 입력받은 글자가 일치하는지 확인
            if (wheel[idx] != '?' && wheel[idx] != c) {
                // 일치하지 않는다면 바로 반복문 나가기
                isLuckyWheel = false;
                break;
            }

            N--;
        }

        int n = size;

        if (isLuckyWheel) {
            while (n > 0) {
                sb.append(wheel[idx]);
                idx = (idx + size - 1) % size;
                n--;
            }
            System.out.println(sb);
        } else {
            System.out.println("!");
        }

    }
}
