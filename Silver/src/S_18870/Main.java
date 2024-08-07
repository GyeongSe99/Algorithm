package S_18870;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = arr.clone();

        Arrays.sort(sortedArr);

        int cnt = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = sortedArr[i];
            if (!map.containsKey(num)) {
                map.put(num, cnt++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int val = map.get(arr[i]);
            sb.append(val).append(" ");
        }

        System.out.println(sb);
    }
}
