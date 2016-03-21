import java.util.ArrayList;
import java.util.Scanner;

public class ArcherArthur {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// Line 1: Three space-separated integers N, S, and R: the total number of trees, the total time, and the reload time
		String line1 = sc.nextLine();
		int numTrees = Integer.parseInt(line1.split(" ")[0]);
		int totalTime = Integer.parseInt(line1.split(" ")[1]);
		int reloadTime = Integer.parseInt(line1.split(" ")[2]);
		totalTime += reloadTime;
		// Lines 2...N+1: Line i+1 contains two space-separated integers D_i and P_i, the distance and point value of tree i
		ArrayList<ArcherTree> trees = new ArrayList<ArcherTree>();
		for (int i = 0; i < numTrees; ++i) {
			String[] input = sc.nextLine().split(" ");
			trees.add(new ArcherTree(Integer.parseInt(input[0]) + reloadTime, Integer.parseInt(input[1])));
		}
		for (int i = 0; i < numTrees - 1; ++i) {
			if (trees.get(i).ratio < trees.get(i + 1).ratio) {
				ArcherTree tmp = trees.get(i + 1);
				trees.set(i + 1, trees.get(i));
				trees.set(i, tmp);
				i -= 2;
				if (i < 0) {
					i = -1;
				}
			}
		}
		// System.out.println(trees);
		int pointsTotal = 0;
		for (int i = 0; i < numTrees; ++i) {
			if (totalTime < trees.get(i).aimTime) continue;
			totalTime -= trees.get(i).aimTime;
			pointsTotal += trees.get(i).points;
		}
		System.out.println(pointsTotal);
	}
	
	public static class ArcherTree implements Comparable<ArcherTree> {
		final int aimTime;
		final int points;
		final float ratio;
		
		public ArcherTree(int aimTime, int points) {
			this.aimTime = aimTime;
			this.points = points;
			this.ratio = ((float) points) / ((float) aimTime);
		}
		
		@Override
		public int compareTo(ArcherTree o) {
			return new Float(o.ratio).compareTo(ratio);
		}
		
		public String toString() {
			return ratio + "";
		}
	}
}
