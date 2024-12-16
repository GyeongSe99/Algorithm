import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_6236 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int end = N * 10000;
        int start = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isPossible(arr, mid, M)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPossible(int[] arr, int mid, int M) {
        int cnt = 1;
        int cur = mid;
        for (int i = 0; i < arr.length; i++) {
            if (mid < arr[i]) {
                return false;
            }

            if (cur < arr[i]) {
                cnt++; // 인출
                cur = mid - arr[i];
            } else if (cur >= arr[i]) {
                cur -= arr[i];
            }

            if (cnt > M) {
                return false;
            }
        }
        return true;
    }

}
