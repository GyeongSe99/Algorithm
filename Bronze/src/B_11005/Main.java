package B_11005;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 10진법 수
        int B = sc.nextInt();  // 표현할 진법의 수
        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            int num = N % B; // 나머지 값.
            N /= B; // 그 다음으로 넘어가기

            // num을 진법으로 바꾸어 char 형태로 저장
            if (num < 10) {
                sb.append((char) (num + '0')); // 0-9의 경우 숫자 그대로
            } else {
                sb.append((char) (num - 10 + 'A')); // 10-35의 경우 A-Z로 변환
            }
        }

        // 저장된 sb를 뒤집어 출력
        System.out.println(sb.reverse());
    }
}
