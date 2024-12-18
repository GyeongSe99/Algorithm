import java.io.BufferedReader;
import java.io.InputStreamReader;

public class G_5430 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
            int left = 0;
            int right = n - 1;
            boolean isReverse = false;
            boolean isError = false;

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (isReverse) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            if (left > right + 1) {
                isError = true;
            }

            if (isError) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                if (isReverse) {
                    for (int j = right; j >= left; j--) {
                        sb.append(arr[j]);
                        if (j != left) {
                            sb.append(",");
                        }
                    }
                } else {
                    for (int j = left; j <= right; j++) {
                        sb.append(arr[j]);
                        if (j != right) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]").append("\n");
            }
        }

        System.out.println(sb);
    }

}
