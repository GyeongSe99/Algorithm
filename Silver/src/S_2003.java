import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S_2003 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N + 1];

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        int start = 0;
        int end = 0;

        while (start <= N && end <= N) {
            int temp = sum[end] - sum[start];

            if (temp == M) {
                cnt++;
                end++;
            } else if (temp < M) {
                end++;
            } else {
                start++;
            }

            if (start > end) {
                end = start;
            }
        }

        System.out.println(cnt);
    }

}
