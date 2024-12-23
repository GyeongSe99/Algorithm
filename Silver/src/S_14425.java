import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S_14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] base = new String[N];
        for (int i = 0; i < N; i++) {
            base[i] =br.readLine();
        }
        Arrays.sort(base);

        int answer = 0;

        for (int i = 0; i < M; i++) {
           String target = br.readLine();
           if (isExist(base, target)) {
               answer++;
           }
        }

        System.out.println(answer);

    }

    private static boolean isExist(String[] arr, String target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int compareResult = arr[m].compareTo(target);
            if (compareResult < 0) {
                l = m + 1;
            } else if (compareResult > 0) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
