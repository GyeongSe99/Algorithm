package S_7785;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] string = br.readLine().split(" ");
            if (string[1].equals("enter")) {
                set.add(string[0]);
            } else {
                set.remove(string[0]);
            }
        }

        List<String> resultList = new ArrayList<>(set);
        resultList.sort(Collections.reverseOrder());

        for (String name : resultList) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
