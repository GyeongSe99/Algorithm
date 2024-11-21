import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S_16165 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 입력 받을 걸그룹 수
        int M = Integer.parseInt(st.nextToken()); // 맞혀야 할 문제 수

        HashMap<String, String[]> group = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            int memberCnt = Integer.parseInt(br.readLine());

            String[] members = new String[memberCnt];
            for (int j = 0; j < memberCnt; j++) {
                members[j] = br.readLine();
                group.put(members[j], new String[]{groupName});
            }
            Arrays.sort(members);
            group.put(groupName, members);
        }

        StringBuilder sb = new StringBuilder();

        // 문제 풀기
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                String[] strings = group.get(name);

                for (int j = 0; j < strings.length; j++) {
                    sb.append(strings[j]).append("\n");
                }
            } else {
                String[] strings = group.get(name);

                sb.append(strings[0]).append("\n");
            }
        }

        System.out.println(sb);
    }

}
