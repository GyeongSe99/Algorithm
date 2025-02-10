import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 비어있는 사진 틀이 없을 경우 추천 횟수가 가장 적은 학생의 사진을 삭제하고 그 자리에 추가,
// 게시된 지 가장 오래된 사진 삭제

public class S_1713 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 사진 틀의 개수
        int M = Integer.parseInt(br.readLine());    // 전체 학생의 총 추천 횟수

        Map<Integer, Integer> map = new HashMap<>();    // 추천받은 학생의 번호, 추천 횟수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] times = new int[101];

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                // map.size 체크
                while (map.size() >= N) {
                    int min = Integer.MAX_VALUE;
                    int minIdx = -1;

                    for (Map.Entry<Integer, Integer> vote : map.entrySet()) {
                        if (vote.getValue() < min) {
                            min = vote.getValue();
                            minIdx = vote.getKey();
                        } else if (vote.getValue() == min) {    // 값이 같으면
                            // 게시된 시간 비교
                            if (times[minIdx] > times[vote.getKey()]) {
                                minIdx = vote.getKey();
                            }
                        }
                    }

                    map.remove(minIdx);
                }

                map.put(num, 1);
                times[num] = i; // 게시될 때 시간 기재
            }
        }

        List<Integer> result = new ArrayList<>(map.keySet());
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);

    }
}
