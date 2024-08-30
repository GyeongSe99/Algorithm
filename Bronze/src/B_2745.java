import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_2745 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int term = 55;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = '0'; i <= '9'; i++) {
            map.put((char)i, i - '0');
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put((char)i, i - term);
        }

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int value = map.get(c);
            result = result * B + value;
        }

        System.out.println(result);
    }

}
