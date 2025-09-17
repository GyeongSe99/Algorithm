public class PG_12903 {
	public String solution(String s) {
		int len = s.length();

		if (len == 1) return s;
		int mid = len / 2;

		if (len % 2 == 0) {
			return s.substring(mid - 1, mid + 1);
		}
		else {
			return s.substring(mid, mid + 1);
		}
	}
}