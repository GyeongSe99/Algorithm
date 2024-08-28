import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2566 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = Integer.MIN_VALUE;
        int r = -1;
        int c = -1;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n > max) {
                    max = n;
                    r = i;
                    c = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((r + 1) + " " + (c + 1));
    }

}
