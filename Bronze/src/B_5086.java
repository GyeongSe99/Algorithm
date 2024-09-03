import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_5086 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            if (a == 0 && b == 0) {
                break;
            }

            if (b % a == 0) {
                sb.append("factor").append("\n");
            } else if (a % b == 0) {
                sb.append("multiple").append("\n");
            } else {
                sb.append("neither").append("\n");
            }
        }

        System.out.println(sb);
    }

}
