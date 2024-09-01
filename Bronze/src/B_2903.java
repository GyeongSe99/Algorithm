import java.util.Scanner;

public class B_2903 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int side = (int)Math.pow(2, n) + 1;
        int total = side * side;

        System.out.println(total);
    }

}
