import java.util.Scanner;

public class DefendTheKingdom {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String nm = sc.nextLine();
		int castleCount = Integer.parseInt(nm.split(" ")[0]);
		int wallCount = Integer.parseInt(nm.split(" ")[1]);
		int queryCount = Integer.parseInt(nm.split(" ")[2]);
		int[][] castles = new int[castleCount][2];
		for (int i = 0; i < castleCount; ++i) {
			String[] input = sc.nextLine().split(" ");
			castles[i][0] = Integer.parseInt(input[0]);
			castles[i][1] = Integer.parseInt(input[1]);
		}
		int[][] walls = new int[wallCount][3];
		for (int i = 0; i < wallCount; ++i) { // x, y, rad
			String[] input = sc.nextLine().split(" ");
			walls[i][0] = Integer.parseInt(input[1]);
			walls[i][1] = Integer.parseInt(input[2]);
			walls[i][2] = Integer.parseInt(input[0]);
		}
		int[][] queries = new int[queryCount][2];
		for (int i = 0; i < queryCount; ++i) {
			String[] input = sc.nextLine().split(" ");
			queries[i][0] = Integer.parseInt(input[0]);
			queries[i][1] = Integer.parseInt(input[1]);
		}
		for (int i = 0; i < queryCount; ++i) {
			int[] query = queries[i];
			int[] castleA = castles[query[0] - 1];
			int[] castleB = castles[query[1] - 1];
			int wallsAroundA = 0;
			int wallsAroundB = 0;
			for (int j = 0; j < wallCount; j++) {
				int[] wall = walls[j];
				boolean inA = isInCircle(wall, castleA);
				boolean inB = isInCircle(wall, castleB);
				if (inA && !inB) {
					wallsAroundA++;
				}
				if (inB && !inA) {
					wallsAroundB++;
				}
			}
			System.out.println(wallsAroundA + wallsAroundB);
		}
	}
	
	public static boolean isInCircle(int[] circle, int[] castle) {
		double circleX = (double) circle[0];
		double circleY = (double) circle[1];
		double circleR = (double) circle[2];
		double castleX = (double) castle[0];
		double castleY = (double) castle[1];
		double diffX = circleX - castleX;
		double diffY = circleY - castleY;
		return diffX * diffX + diffY * diffY < circleR * circleR;
	}
}
