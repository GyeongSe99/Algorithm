package S_1302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> sells = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            sells.put(s, sells.getOrDefault(s, 0) + 1);
        }

        String mostSoldBookName = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : sells.entrySet()) {
            String name = entry.getKey();
            int cnt = entry.getValue();

            if (max < cnt) {
                mostSoldBookName = name;
                max = cnt;
            } else if (max == cnt) {
                mostSoldBookName = mostSoldBookName.compareTo(name) < 0 ? mostSoldBookName : name;
            }
        }

        System.out.println(mostSoldBookName);

    }
}
