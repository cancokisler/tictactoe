import java.util.Scanner;

public class new_tictactoe {

	static int check = 0;
	private void print_board() {

		for(int i=0; i <3; i++) {
			for(int j = 0; j < 1; j++) {

				System.out.println(board[i][j]+"|"+board[i][j+1]+"|"+board[i][j+2]);


			}
		}
	}

	private static char [][] board = { 
			{'-','-','-'},
			{'-','-','-'},
			{'-','-','-'},
	};
	
	private static boolean BoardFull() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j<3; j++) {
				if(board[i][j] == 'X' || board[i][j] == 'O') {
					check += 1;

				}
			}

		}
		return(check >= 9);

	}


	public static void main(String[] args) {
		boolean ticker = false;

		new_tictactoe game = new new_tictactoe();
		game.print_board();
		while(!BoardFull() || !ticker) {
			Scanner player_input = new Scanner(System.in);

			int mark1 = Integer.parseInt(player_input.next());
			int mark2 = Integer.parseInt(player_input.next());
			
			board [mark1][mark2] = 'X';
			System.out.println(" ");
			game.print_board();
			BoardFull();
			
			if(winVertical() || winHorizontal() || winDiagonal()) {
				System.out.println("DONE!");
				ticker = true;
				break;
			}


			int mark3 = Integer.parseInt(player_input.next());
			int mark4 = Integer.parseInt(player_input.next());
			if(winVertical() || winHorizontal() || winDiagonal()) {
				System.out.println("DONE!");
						
				ticker = true;
				break;
			}
				
			
			board [mark3][mark4] = 'O';
			System.out.println(" ");
			game.print_board();

		}


	}

	private static boolean winVertical() {
		int j = 0;
		for(int i = 0 ; i<3 ; i++) {
			 
				if(board[j][i] == 'X' && board[j+1][i] == 'X'&& board[j+2][i] == 'X') {
					return true;
					
				}
				else if(board[j][i] == 'O'&& board[j+1][i] == 'O'&& board[j+2][i] == 'O'){
					return true;
				}
			
			
		}
		return false;
	}
	
	private static boolean winHorizontal() {
		int j = 0;
		for(int i = 0 ; i<3 ; i++) {
			
				if(board[i][j] == 'X' && board[i][j+1] == 'X'&& board[j][i] == 'X') {
					return true;
				}
				else if(board[i][j] == 'X' && board[i][j+1] == 'X'&& board[j][i] == 'X') {
					return true;
			
				}
		
		}
		return false;
	}
	
	private static boolean winDiagonal() {
		int j = 2;
		
		if((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
				|| (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')) {
			return true;
			
		}
		else if((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
				|| (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')){
			return true;
		}
		return false;
	}
	
	
}
