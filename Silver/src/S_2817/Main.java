package S_2817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Candidate{
        char name;
        int voteNum;
        int chip;

        public Candidate(char name, int voteNum) {
            this.name = name;
            this.voteNum = voteNum;
            this.chip = 0;
        }
    }

    private static int X, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        X = Integer.parseInt(br.readLine());    // 참가자수
        N = Integer.parseInt(br.readLine());    // 스태프 수

        if (N == 0) {
            System.out.println();
            return;
        }

        // 득표수 5% 미만의 자격 없는 스태프를 거른 후보자 명단
        ArrayList<Candidate> candidates = new ArrayList<>();
        int n = 0;

        // 후보자 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char name = st.nextToken().charAt(0);
            int voteNum = Integer.parseInt(st.nextToken());

            // isCandidate(voteNum) : 득표 수가 5% 미만인지 아닌지 계산 하는 메소드
            if (isCandidate(voteNum)) {
                candidates.add(new Candidate(name, voteNum));
            }
        }

        // 각 후보자들의 점수 14개가 담겨져있는 map (점수 : candidates Idx)
        Map<Double, Integer> scoresMap = new HashMap<>();

        for (int i = 0; i < candidates.size(); i++) {
            // 14개의 점수 계산
            for (int j = 1; j <= 14; j++) {
                double score = calculateScore(j, candidates.get(i).voteNum);
                scoresMap.put(score, i);
            }
        }

        // map double 기준 내림차순 정렬
        List<Map.Entry<Double, Integer>> sortedScores = new ArrayList<>(scoresMap.entrySet());
        sortedScores.sort((entry1, entry2) -> Double.compare(entry2.getKey(), entry1.getKey()));

        // 높은 점수부터 14개 칩 주기
        for (int i = 0; i < 14; i++) {
            candidates.get(sortedScores.get(i).getValue()).chip++;
        }

        candidates.sort(Comparator.comparing(c -> c.name));
        for (Candidate candidate : candidates) {
            System.out.println(candidate.name + " " + candidate.chip);
        }
    }

    private static double calculateScore(int n, int voteNum) {
        return (double) voteNum / (double) n;
    }

    private static boolean isCandidate(int voteNum) {
        return (double) voteNum / X > 0.05;
    }
}
