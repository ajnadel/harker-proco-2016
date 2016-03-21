import java.util.Scanner;

public class KingdomSize {
	static int m;
	static int n;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		m = Integer.parseInt(input.split(" ")[0]);
		n = Integer.parseInt(input.split(" ")[1]);
		knownOutside = new boolean[m][n];
		map = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) == 'X';
			}
		}
		for (int i = 0; i < m; i++) {
			markOutside(i, 0);
			markOutside(i, n - 1);
		}
		for (int i = 0; i < n; i++) {
			markOutside(0, i);
			markOutside(m - 1, i);
		}
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!map[i][j] && !knownOutside[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	static boolean[][] map;
	static boolean[][] knownOutside;
	
	public static void markOutside(int i, int j) {
		if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
			return;
		}
		if (knownOutside[i][j]) {
			return;
		}
		if (map[i][j]) {
			return;
		}
		knownOutside[i][j] = true;
		markOutside(i + 1, j);
		markOutside(i - 1, j);
		markOutside(i, j + 1);
		markOutside(i, j - 1);
	}
}
