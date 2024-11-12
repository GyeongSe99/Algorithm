import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

public class S_2852 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        LocalTime[] teams = new LocalTime[3];
        for (int i = 0; i < teams.length; i++) {
            teams[i] = LocalTime.of(0, 0, 0);
        }
        LocalTime now = LocalTime.of(0, 0, 0);
        int[] score = new int[3];

        int nowWinner = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int teamNum = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            sb.append("00:").append(st.nextToken());
            LocalTime curTime = LocalTime.parse(sb.toString());

            // 무승부일 때
            if (nowWinner == 0) {
                score[teamNum] += 1;
                now = curTime;
            } else {
                score[teamNum] += 1;
                // 일단 현재까지 이기고 있었던 팀한테 시간 더해주기
                LocalTime time = curTime.minusHours(now.getHour()).minusMinutes(now.getMinute()).minusSeconds(now.getSecond());
                now = curTime;

                teams[nowWinner] = teams[nowWinner].plusHours(time.getHour()).plusMinutes(time.getMinute()).plusSeconds(time.getSecond());
            }

            // 누가 이기고 있는지 계산
            if (score[1] > score[2]) {
                nowWinner = 1;
            } else if (score[1] < score[2]) {
                nowWinner = 2;
            } else {
                nowWinner = 0;
            }
        }

        LocalTime curTime = LocalTime.of(0, 48, 0);

        // 마지막 경기가 끝나고 누가 이기고 있는지 계산
        if (nowWinner != 0) {
            LocalTime time = curTime.minusHours(now.getHour()).minusMinutes(now.getMinute()).minusSeconds(now.getSecond());
            teams[nowWinner] = teams[nowWinner].plusHours(time.getHour()).plusMinutes(time.getMinute()).plusSeconds(time.getSecond());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss");

        System.out.println(teams[1].format(formatter));
        System.out.println(teams[2].format(formatter));

    }

}
