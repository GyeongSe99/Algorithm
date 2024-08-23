import java.io.BufferedReader;
import java.io.InputStreamReader;

// 교실엔 무조건 30명의 학생이 있음.
//1번부터 30번까지 있음

public class B_5597 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] students = new int[31];

        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());

            students[n] = 1;
        }

        for (int i = 1; i < 31; i++) {
            if (students[i] == 0) {
                System.out.println(i);
            }
        }


    }

}
