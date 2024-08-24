import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_11718 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

}
