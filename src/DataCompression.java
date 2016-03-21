import java.util.Scanner;

public class DataCompression {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		for (int index = 0; index < line.length();) {
			char c = line.charAt(index);
			int count = 1;
			for (int j = index + 1; j < line.length(); j++) {
				if (line.charAt(j) == c) {
					count++;
				} else {
					break;
				}
			}
			System.out.print(c + "" + count);
			index += count;
		}
	}
}
