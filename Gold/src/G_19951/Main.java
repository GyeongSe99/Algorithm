package G_19951;

// 19951 : 태상이의 훈련소 생활

// 연병장 크기 N, 조교 수 M
// 누적합
// 범위 연산 수치를 기록하는 배열 delta
// 모든 칸에 대한 변화량을 기록하지 않고 처음과 끝만 기록한다
// ex) 2번부터 7번까지 -2 연산을 한다고 하면, 2번부터 끝까지 -2를 한 후, 7번 + 1부터 끝까지 +2를 하는 것과 같다.
// delta 배열에 시작부분에 k, 끝 부분 다음부터 -k를 기록한다.
// 이후 resultDelta 배열을 만들어 delta 배열을 누적합한 다음 기존 연병장에 변화량을 계산하여 출력한다.
// 누적합이 되는 이유 : 앞의 변화량이 뒤의 변화량에도 계속 누적되어 계산되기 때문

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 연병장 크기
        int M = Integer.parseInt(st.nextToken());   // 조교 수

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] delta = new int[N + 2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            delta[a] += k;
            delta[b + 1] -= k;
        }

        int[] resultDelta = new int[N + 1];
        for (int i = 1; i < resultDelta.length; i++) {
            resultDelta[i] = resultDelta[i - 1] + delta[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i] + resultDelta[i]).append(" ");
        }
        System.out.println(sb);
    }

}
