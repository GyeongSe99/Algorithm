package S_4948;
// 베르트랑 공준

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int Max = 123456 * 2;
    static ArrayList<Integer> decimalList = new ArrayList<>();
    static int[] cntArr = new int[Max + 1];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 2; i <= Max; i++) {
            decimalList.add(i);
        }

        for (int i = 2; i <= Max; i++) {
            for (int idx = decimalList.size() - 1; idx >= 0; idx--) {
                if (decimalList.get(idx).equals(i)) break;

                // 자기자신이 아니고 나누어 떨어지면 list에서 제거
                if (decimalList.get(idx) % i == 0) {
                    decimalList.remove(idx);
                }
            }
        }

        // 어떠한 숫자 보다 작은 소수의 개수를 기록
        cntArr[0] = 0;
        int idx = 0;
        int tmp = 0;

        for (int i = 0; i < Max + 1; i++) {
            int curNum = decimalList.get(idx); // 소수

            // 현재보고있는 소수가 i보다 크면
            if (i < curNum) {
                cntArr[i] = tmp;
            } else {    // idx번째 소수가 i보다 작으면
                if (idx + 1 < decimalList.size()) {
                    idx++;
                    tmp++;
                    cntArr[i] = tmp;
                } else {
                    cntArr[i] = tmp;
                }
            }
        }

        ArrayList<Integer> input = new ArrayList<>();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            input.add(n);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.size(); i++) {
            int num = input.get(i);
            sb.append((cntArr[num * 2] - cntArr[num])).append("\n");
        }

        System.out.println(sb);
    }
}
