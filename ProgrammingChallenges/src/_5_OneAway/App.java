package _5_OneAway;

public class App {

	public static void main(String[] args) {
		
		String s = "freya";
		String t = "freyamd";
		System.out.println(isOneAway(s, t));
		
	}
	
	public static boolean isOneAway(String first, String second) {
		
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		}
		return false;
	}
	
	private static boolean oneEditReplace(String first, String second) {
		
		boolean oneDifference = false;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)) {
				if (oneDifference) {
					return false;
				}
				oneDifference = true;
			}
		}
		return true;
	}
	
	private static boolean oneEditInsert(String first, String second) {
		
		int index1 = 0;
		int index2 = 0;
		while  (index1 < first.length() && index2 < second.length()) {
			if (first.charAt(index1) != second.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
}
