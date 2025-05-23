public class PG_12919 {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                sb.append(String.format("김서방은 %d에 있다", i));
            }
        }
        return sb.toString();
    }
}
