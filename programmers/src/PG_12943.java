public class PG_12943 {
    public int solution(int num) {
        int answer = -1;
        int cnt = 0;
        long ln = num;
        while (cnt < 500) {
            System.out.println("-------------");
            System.out.println("cnt : " + cnt);
            System.out.println("ln : " + ln);
            if (ln == 1) {
                answer = cnt;
                break;
            }

            if (ln % 2 == 0) {
                ln /= 2;
            } else {
                ln = ln * 3 + 1;
            }
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        PG_12943 p = new PG_12943();
//        System.out.println(p.solution(626331));
        System.out.println(p.solution(6));
    }
}
