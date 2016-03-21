import java.util.Scanner;

public class UndampedOscillations {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int m = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < 50; i++) {
			int x = attempt(m, 0, 1, i);
			if (x != -1) {
				System.out.println(x - 1);
				return;
			}
		}
		System.out.println("NONE");
	}
	
	public static int attempt(int goal, int current, int index, int max) {
		if (index >= max) {
			return -1;
		}
		if (current == goal) {
			return index;
		}
		int x = attempt(goal, current + index, index + 1, max);
		if (x != -1) {
			return x;
		}
		return attempt(goal, current - index, index + 1, max);
	}
}
