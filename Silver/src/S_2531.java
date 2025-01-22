import java.io.*;
import java.util.*;

public class S_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 회전 초밥 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken());   // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        // 초밥의 가짓수와 각 초밥의 개수를 저장할 배열
        int[] count = new int[d + 1];
        int uniqueCount = 0; // 현재 초밥의 개수

        // 초기 슬라이딩 윈도우 설정
        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) uniqueCount++;
            count[belt[i]]++;
        }

        // 쿠폰 초밥 포함 여부를 계산하여 초기 최대값 설정
        int max = uniqueCount + (count[c] == 0 ? 1 : 0);

        // 슬라이딩 윈도우 이동
        for (int i = 1; i < N; i++) {
            // 왼쪽 초밥 제거
            int left = belt[i - 1];
            count[left]--;
            if (count[left] == 0) uniqueCount--;

            // 오른쪽 초밥 추가
            int right = belt[(i + k - 1) % N];
            if (count[right] == 0) uniqueCount++;
            count[right]++;

            // 최대값 갱신
            max = Math.max(max, uniqueCount + (count[c] == 0 ? 1 : 0));
        }

        System.out.println(max);
    }
}
