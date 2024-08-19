import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_25304 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int pay = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int price = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            sum += price * count;
        }

        if (pay == sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
