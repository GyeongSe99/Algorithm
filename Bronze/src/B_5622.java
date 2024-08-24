import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_5622 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int time = 0;

        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'C') {
                time += 3;
            } else if (ch >= 'D' && ch <= 'F') {
                time += 4;
            } else if (ch >= 'G' && ch <= 'I') {
                time += 5;
            } else if (ch >= 'J' && ch <= 'L') {
                time += 6;
            } else if (ch >= 'M' && ch <= 'O') {
                time += 7;
            } else if (ch >= 'P' && ch <= 'S') {
                time += 8;
            } else if (ch >= 'T' && ch <= 'V') {
                time += 9;
            } else if (ch >= 'W' && ch <= 'Z') {
                time += 10;
            }
        }

        System.out.println(time);
    }

}
