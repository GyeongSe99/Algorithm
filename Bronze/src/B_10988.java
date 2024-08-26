import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_10988 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int s = 0;
        int e = str.length() - 1;

        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                System.out.println(0);
                return;
            }

            s++;
            e--;
        }

        System.out.println(1);

    }
}
