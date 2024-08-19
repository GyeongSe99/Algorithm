import java.util.Scanner;

// 코딩은 체육과목 입니다

public class B_25314 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String prefix = "long";
        String postfix = "int";

        int n = sc.nextInt();

        int result = n % 4 == 0 ? n / 4 : n / 4 + 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result; i++) {
            sb.append(prefix).append(" ");
        }
        sb.append(postfix);

        System.out.println(sb);

    }

}
