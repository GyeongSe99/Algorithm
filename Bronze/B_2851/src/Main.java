// 백준 2851 : 슈퍼마리오

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int targetScore = 100;
    static int T = 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> mushrooms = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            mushrooms.add(Integer.parseInt(br.readLine()));
        }
        
        int firstIdx = 0;
        int lastIdx = 0;
        
        int sum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int answer = 0;

        // 처음부터 더했을때
        while (lastIdx < mushrooms.size()) {
            sum += mushrooms.get(lastIdx);
            // sum이 100보다 작으면 그 다음 숫자를 더했을때 100이랑 더 비슷할 수 있으므로
            // lastIdx를 늘리고 다음 수까지 더하기 위해 continue를 한다.
            if (sum < 100) {
                lastIdx++;
                result.add(sum);
            } else if (sum == 100) {
                answer = 100;
                break;
            } else {
                // 넘으면 앞에숫자를 하나 빼고 뒤에 숫자를 넣어보기
                if (firstIdx < lastIdx) {
                    sum -= mushrooms.get(firstIdx);
                    firstIdx++;
                    lastIdx++;
                }
            }
        }
        
    }
}