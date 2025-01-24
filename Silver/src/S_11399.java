import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] sum = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        sum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            res += sum[i];
        }

        System.out.println(res);
    }
}
