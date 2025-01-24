import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_31403 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        int c = Integer.parseInt(C);

        System.out.println(a+b-c);
        System.out.println(Integer.parseInt(A+B) - c);

    }
}
