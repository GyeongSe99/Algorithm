import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 공백 기준으로 자르기
// 과목명 점수 학점
// 전공 평점 = (학점 * 과목평점)의 합을 학점의 총점으로 나눈 값
// 등급이 P인 과목은 계산에서 제외

public class S_25206 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = 20;

        Map<String, Double> gradeTable = new HashMap<>();
        gradeTable.put("A+", 4.5);
        gradeTable.put("A0", 4.0);
        gradeTable.put("B+", 3.5);
        gradeTable.put("B0", 3.0);
        gradeTable.put("C+", 2.5);
        gradeTable.put("C0", 2.0);
        gradeTable.put("D+", 1.5);
        gradeTable.put("D0", 1.0);
        gradeTable.put("F", 0.0);

        double total = 0.0;
        double cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!grade.equals("P")) {
                total += score * gradeTable.get(grade);
                cnt += score;
            }
        }
        System.out.println(total / cnt);

    }

}
