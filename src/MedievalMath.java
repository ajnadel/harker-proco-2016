import java.math.BigInteger;
import java.util.Scanner;

public class MedievalMath {
	static int operationCount;
	static int balance;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		operationCount = Integer.parseInt(sc.nextLine());
		balance = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < operationCount; ++i) {
			String input = sc.nextLine();
			String command = input.split(" ")[0];
			int value = Integer.parseInt(input.split(" ")[1]);
			if (command.equals("ADD")) balance += value;
			else if (command.equals("SUB")) balance -= value;
			else if (command.equals("MUL")) balance *= value;
			else if (command.equals("DIV")) balance /= value;
			else if (command.equals("COB")) balance = new BigInteger(balance + "", value).intValue();
		}
		System.out.println(balance);
	}
}
