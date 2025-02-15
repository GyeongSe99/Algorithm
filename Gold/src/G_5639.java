import java.io.BufferedReader;
import java.io.InputStreamReader;

public class G_5639 {
    private static StringBuilder sb = new StringBuilder();
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }

        void insert(int num) {
            if (num < this.data) {
                if (this.left == null) {
                    this.left = new Node(num);
                } else {
                    this.left.insert(num);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(num);
                } else {
                    this.right.insert(num);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        Node root = new Node(Integer.parseInt(br.readLine()));

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int num = Integer.parseInt(input);
            root.insert(num);
        }

        postOrder(root);
        System.out.println(sb);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.data).append("\n");
    }
}
