import java.util.Scanner;

public class S_15828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        int[] buffer = new int[N + 1];
        int front = 0;
        int rear = 0;

        while (true) {
            int cur = sc.nextInt();

            if (cur == -1) {
                break;
            }

            // 빼야 됌
            if (cur == 0) {
                // 맨앞이면 skip
                front = (front + 1) % buffer.length;
            } else {    // 넣어야 됌
                // 꽉찼으면 skip
                if ((rear + 1) % buffer.length == front) {
                    continue;
                }
                rear = (rear + 1) % buffer.length;
                buffer[rear] = cur;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = front; i != rear; i = (i + 1) % buffer.length) {
            sb.append(buffer[(i + 1) % buffer.length]).append(" ");
        }

        if (sb.length() > 0) {
            System.out.println(sb);
        } else {
            System.out.println("empty");
        }

    }

}
