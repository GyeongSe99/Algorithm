import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S_17254 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 총 게임횟수
        int P = Integer.parseInt(st.nextToken());   // 플레이어의 수

        st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());   // 이겼을때 획득 점수
        int L = Integer.parseInt(st.nextToken());   // 졌을때 잃는 점수
        int G = Integer.parseInt(st.nextToken());   // 티어에서 벗어나기 위한 점수

        Set<String> winSet = new HashSet<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (st.nextToken().equals("W")) winSet.add(name);
        }

        int score = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (winSet.contains(s)) score += W;
            else score = Math.max(score - L, 0);
            if (score >= G) {
                System.out.println("I AM NOT IRONMAN!!");
                return;
            }
        }
        System.out.println("I AM IRONMAN!!");
    }
}
