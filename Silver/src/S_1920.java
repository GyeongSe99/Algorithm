import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N - 1;
            boolean flag = false;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr1[mid] > num) {
                    right = mid - 1;
                } else if (arr1[mid] == num) {
                    flag = true;
                    break;
                } else {
                    left = mid + 1;
                }
            }

            if (flag) {
                sb.append('1').append("\n");
            } else {
                sb.append('0').append("\n");
            }
        }

        System.out.println(sb);
    }
}
