import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 집의 개수
        int C = Integer.parseInt(st.nextToken());   // 공유기의 개수

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int result = 0;
        int left = 1, right = houses[N - 1] - houses[0];

        while (left <= right) {
            int mid = (left + right) / 2;   // 최소 간격 설정.

            // 첫번째 집은 무조건 공유기 설치
            int cnt = 1;
            int lastInstalled = houses[0];  // 마지막으로 설치한 집의 좌표

            // mid를 기준으로 공유기 설치. 첫번째 집은 무조건 설치니깐 1부터 시작
            for (int i = 1; i < N; i++) {
                // 설치하려는 집의 좌표와 이전에 설치한 집의 좌표 간격이 mid보다 클 때 설치
                if (houses[i] - lastInstalled >= mid) {
                    cnt++;
                    lastInstalled = houses[i];
                }
            }

            if (cnt >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);


    }
}
