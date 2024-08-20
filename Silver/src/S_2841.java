import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class S_2841 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Stack<Integer>> guitar = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            guitar.add(new Stack<>());
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int lineNum = Integer.parseInt(st.nextToken()) - 1;
            int fret = Integer.parseInt(st.nextToken());

            Stack<Integer> line = guitar.get(lineNum);

            while (!line.isEmpty() && line.peek() > fret) {
                line.pop();
                result++;
            }

            if (line.isEmpty() || line.peek() != fret) {
                line.push(fret);
                result++;
            }

            guitar.set(lineNum, line);
        }

        System.out.println(result);
    }

}
