import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_9506 {
    private static String incorrect = "is NOT perfect";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n;

        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == -1) {
                break;
            }

            int perfectN = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    perfectN += i;
                    sb.append(i).append(" + ");
                }
            }

            if (perfectN == n) {
                sb.delete(sb.length()-3, sb.length()-1);
                System.out.println(n + " = " + sb);
            } else {
                System.out.println(n + " " + incorrect);
            }
        }
    }

}
