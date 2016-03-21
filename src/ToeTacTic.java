import java.util.Scanner;

public class ToeTacTic {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char turn = sc.nextLine().charAt(0);
		char[][] board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < 3; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		int r = new Board(board).solve(turn);
		System.out.println(r == 1 ? "YES" : "NO");
	}
	
	public static class Board {
		char[][] board;
		
		public Board(char[][] board) {
			this.board = new char[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					this.board[i][j] = board[i][j];
				}
			}
		}
		
		public int solve(char turn) {
			char win = checkWin();
			if (win != '.') {
				return turn != win ? 1 : -1;
			}
			boolean hasTie = false;
			boolean boardFull = true;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j] != '.') {
						continue;
					}
					boardFull = false;
					Board tmp = new Board(board);
					tmp.board[i][j] = turn;
					int k = tmp.solve(turn == 'O' ? 'X' : 'O');
					if (k == 0) {
						hasTie = true;
					}
					if (k == -1) {
						return 1;
					}
				}
			}
			if (boardFull) {
				return 0;
			}
			return hasTie ? 0 : -1;
		}
		
		public char checkWin() {
			for (int i = 0; i < 3; i++) {
				if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '.') {
					return board[0][i];
				}
				if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][1] != '.') {
					return board[i][0];
				}
			}
			if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '.') {
				// return board[0][0];
			}
			if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != '.') {
				// return board[1][1];
			}
			return '.';
		}
	}
}
