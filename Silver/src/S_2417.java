import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S_2417 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(findSqrt(n));
    }

    private static long findSqrt(long n) {
        if (n == 0 || n == 1) return n;

        long l = 1, r = 1L << 32, sqrt = 0;
        while (l <= r) {
            long mid = (l + r) / 2;

            if (Math.pow(mid, 2) >= n) {
                r = mid - 1;
                sqrt = mid;
            } else {
                l = mid + 1;
            }
        }
        return sqrt;
    }
}