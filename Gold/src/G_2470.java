import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_2470 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE; // 0과의 차이

        int ans1 = 0;
        int ans2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

    private static String solution2(int[] arr, int N) {
        Arrays.sort(arr);

        int ansAbs = Math.abs(arr[0] + arr[1]);
        int ans1 = arr[0];
        int ans2 = arr[1];
        for (int i = 0; i < N - 1; i++) {
            int pair = findPair(arr, i + 1, N - 1, arr[i]);
            int sumAbs = Math.abs(arr[i] + pair);
            if (ansAbs > sumAbs) {
                ansAbs = sumAbs;
                ans1 = arr[i];
                ans2 = pair;
            }
        }

        return ans1 + " " + ans2;
    }

    private static int findPair(int[] arr, int start, int end, int value) {
        int pair = arr[start];
        int min = Math.abs(arr[start] + value);
        int left = start, right = end;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = arr[mid] + value;
            int sumAbs = Math.abs(sum);
            if (sumAbs < min) {
                pair = arr[mid];
                min = sumAbs;
            }
            if (sum < 0) left = mid + 1;
            else if (sum > 0) right = mid - 1;
            else return arr[mid];
        }

        return pair;
    }

}
