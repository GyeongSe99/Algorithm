import java.util.stream.Collectors;

public class PG_12933 {
    public long solution(long n) {
        String sorted = String.valueOf(n)
                .chars()
                .mapToObj(c -> String.valueOf((char)c))
                .sorted((a, b) -> b.compareTo(a)).collect(Collectors.joining());
        return Long.parseLong(sorted);
    }
}
