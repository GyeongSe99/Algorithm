import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class S_1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                res.add(s);
            }
        }
        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        sb.append(res.size()).append("\n");

        for (String re : res) {
            sb.append(re).append("\n");
        }
        System.out.println(sb);
    }
}
