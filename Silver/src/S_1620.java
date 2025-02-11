import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S_1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> stringMap = new HashMap<>();
        Map<Integer, String> integerMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            stringMap.put(s, i);
            integerMap.put(i, s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (stringMap.containsKey(s)) {
                sb.append(stringMap.get(s)).append("\n");
            } else {
                sb.append(integerMap.get(Integer.parseInt(s))).append("\n");
            }
        }

        System.out.println(sb);
    }
}
