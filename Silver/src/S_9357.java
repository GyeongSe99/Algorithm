import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S_9357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                 String tag = st.nextToken();
                 map.put(tag, map.getOrDefault(tag, 0) + 1);
            }

            int result = 1;

            for (String key : map.keySet()) {
                result *= map.get(key) + 1;
            }

            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }
}
