import java.util.*;

public class PG_72411 {
    private static Map<String, Integer> combinationCount;

    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        // 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }

        for (int c : course) {
            combinationCount = new HashMap<>();

            // 조합 구하기
            for (String order : orders) {
                combination(order, new StringBuilder(), 0, c);
            }

            int maxCnt = 0;
            // 최대값 찾기
            for (Map.Entry<String, Integer> entry : combinationCount.entrySet()) {
                int curCnt = entry.getValue();
                if (curCnt > maxCnt) maxCnt = curCnt;
            }

            // cnt가 최대값이 모든 조합 결과에 추가
            if (maxCnt > 1) {
                for (Map.Entry<String, Integer> entry : combinationCount.entrySet()) {
                    if (entry.getValue() == maxCnt) {
                        result.add(entry.getKey());
                    }
                }
            }
        }

        String[] answer = result.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }

    private static void combination(String order, StringBuilder sb, int idx, int length) {
        if (sb.length() == length) {
            String s = sb.toString();
            combinationCount.put(s, combinationCount.getOrDefault(s, 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combination(order, sb, i + 1, length);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        PG_72411 pg = new PG_72411();
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2, 3, 4};
        pg.solution(orders1, course1);
    }
}
