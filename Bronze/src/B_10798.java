import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_10798 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Character>[] alpa = new ArrayList[15];
        for (int i = 0; i < 15; i++) {
            alpa[i] = new ArrayList<>();
        }

        for (int i = 0; i < 5; i++) {
            char[] cArr = br.readLine().toCharArray();

            for (int j = 0; j < cArr.length; j++) {
                alpa[j].add(cArr[j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (char c : alpa[i]) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }

}
