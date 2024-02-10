import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += Math.abs(arr[i] - arr[j]);
            }
        }

        System.out.println(sum);
    }
}