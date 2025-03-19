import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());

            // 1. x 이상의 값이 처음으로 나타나는 위치를 구한다.
            int lowerBoundIndex = findLowerBoundIndex(arr, n);
            // 2. x 초과의 값이 처음으로 나타나는 위치를 구한다.
            int upperBoundIndex = findUpperBoundIndex(arr, n);
            // 3. 두 값을 이용해 x의 개수를 센다.
            sb.append(upperBoundIndex - lowerBoundIndex).append(" ");
        }
        System.out.println(sb);
    }

    private static int findUpperBoundIndex(int[] arr, int n) {
        // n 초과의 값이 처음으로 나타나는 위치
        int upperBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] <= n) {
                l = m + 1;
            } else {
                r = m - 1;
                upperBoundIndex = m;
            }
        }
        return upperBoundIndex;
    }

    private static int findLowerBoundIndex(int[] arr, int n) {
        // n 이상의 값이 처음으로 나타나는 위치
        int lowerBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < n) {
                l = m + 1;
            } else {
                r = m - 1;
                lowerBoundIndex = m;
            }
        }
        return lowerBoundIndex;
    }
}
