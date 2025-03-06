import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class G_2295 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sums = new int[N * (N + 1) / 2];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums[idx++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sums);

        int max = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = arr[i] - arr[j];
                if (binarySearch(sums, num)) max = Math.max(max, arr[i]);
            }
        }

        System.out.println(max);
    }

    private static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
