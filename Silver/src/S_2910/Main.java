package S_2910;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 빈도 세는 map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // 순서 기록하는 map
        Map<Integer, Integer> orderMap = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
            if (!orderMap.containsKey(n)) {
                orderMap.put(n, i);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int compare = o2.getValue() - o1.getValue();
                return compare == 0 ? orderMap.get(o1.getKey()) - orderMap.get(o2.getKey()) : compare;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, Integer> entry : entryList) {
            int key = entry.getKey();
            int val = entry.getValue();
            for (int i = 0; i < val; i++) {
                sb.append(key).append(" ");
            }
        }

        System.out.println(sb);


    }
}
