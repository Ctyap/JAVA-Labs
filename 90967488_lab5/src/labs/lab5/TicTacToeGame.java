package labs.lab5;
import java.util.Scanner;

public class TicTacToeGame implements Game {
	private char player1;
	private char player2;
	private int firstMove = 0;
	private int _firstMove = 0;
	private int moveTurn = 0;

	
	
	//static //Create 3 x 3 board on which players can place either 'x' or 'o' in any blank spot.
	//char[][] board = new char[3][3];
	char[][] board = new char[][]{
		  {' ',' ',' '},
		  {' ',' ',' '},
		  {' ',' ',' '}
		}; 
	
	//Visual for board spaces of x and o
	
	public void boardVisual() {
	for(int i = 0; i < 3; i++) {
		for(int j = 0; j < 3; j++) {
			board[i][j] = '-';
		}
	  }
	}
	
	//Create string variable displayBoard
	//String displayBoard = "";
	
	public boolean isValidMove(String move) {
		
		if (move.length() != 3){return false;}
		
		boolean isNumeric = move.substring(0,2).chars().allMatch( Character::isDigit );
		if (isNumeric != true){return false;}
		
		
		int row = Integer.parseInt(String.valueOf(move.charAt(0)));
		int col = Integer.parseInt(String.valueOf(move.charAt(1)));
		char playerSymbol = move.charAt(2);
		
		//System.out.println(playerSymbol);
		if (playerSymbol == 'x' || playerSymbol == 'o') {}else {return false;}
		

		
		// Assigns player1 and player2
		//System.out.println("firstMove Variable: " + firstMove);
		//System.out.println("Player Symbol: " + playerSymbol);
		if (firstMove == 0){
			player1 = playerSymbol;
			firstMove++;}
	
		else if (firstMove == 1) {
			if(playerSymbol == player1) {
				return false;
			}else {
				player2 = playerSymbol;
				firstMove++;
			}
		}
		
		
	
		//System.out.println("It passed.");
		
		//if (player1 == player2) {return false;}
		

		//System.out.println("Player 1 is " + player1);
		//System.out.println("Player 2 is " + player2);

		try {
			if (board[row][col] != ' ') {return false;}

		}
		catch(ArrayIndexOutOfBoundsException exception) {
			return false;
		}
		
		
		//System.out.println("\nmoveTurn Variable: " + moveTurn);
		//System.out.println("Current Player Symbol: " + playerSymbol);
		//System.out.println("Player1: " + player1 + "Player2 " +player2);
		
		//Makes sure same player doesnt go twice checking player symbol.
		if (moveTurn == 0) {
			if (player1 != playerSymbol) {
				moveTurn=0;
				return false;}
			else{moveTurn=1;}
			
		}else if (moveTurn == 1) {
			if (player2 != playerSymbol) {
				moveTurn=1;
				return false;}
			else{moveTurn=0;}
		}return true;

	}

	public void executeMove(String move) {
		
		int row = Integer.parseInt(String.valueOf(move.charAt(0)));
		int col = Integer.parseInt(String.valueOf(move.charAt(1)));
		char playerSymbol = move.charAt(2);
		
		if (_firstMove == 0){
			player1 = playerSymbol;
			_firstMove++;}
	
		else if (_firstMove == 1) {
				player2 = playerSymbol;
				_firstMove++;
			}
		
		board[row][col] = playerSymbol;
	}

	public boolean gameOver() {
		//System.out.println(this.determineWinner());
		if (determineWinner() == 1 || determineWinner() == 2 || determineWinner() == 0) {
			return true;
		}
		return false;
	}
	
	public String displayBoard() {
		String displayBoard = "";

		displayBoard = " " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " " + System.lineSeparator();
		displayBoard += "-----------" + System.lineSeparator();
		displayBoard += " " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " " + System.lineSeparator();
		displayBoard += "-----------" + System.lineSeparator(); 
		displayBoard += " " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " " + System.lineSeparator();
		return displayBoard;
	}
	
	public int determineWinner() {
		int winner = 3;
		int filled = 0;
				
		for (int i = 0; i < 8; i++) {
			String checkWinner = "";
			
			switch(i) {
			case 0:
				checkWinner += board[0][0];
				checkWinner += board[0][1];
				checkWinner += board[0][2];
				
				break;
			case 1:
				checkWinner += board[1][0];
				checkWinner += board[1][1];
				checkWinner += board[1][2];

				break;
			case 2:
				checkWinner += board[2][0];
				checkWinner += board[2][1];
				checkWinner += board[2][2];

				break;
			case 3:
				checkWinner += board[0][0];
				checkWinner += board[1][0];
				checkWinner += board[2][0];

				break;
			case 4:
				checkWinner += board[0][1];
				checkWinner += board[1][1];
				checkWinner += board[2][1];

				break;
			case 5:
				checkWinner += board[0][2];
				checkWinner += board[1][2];
				checkWinner += board[2][2];

				break;
			case 6:
				checkWinner += board[0][0];
				checkWinner += board[1][1];
				checkWinner += board[2][2];

				break;
			case 7:
				checkWinner += board[2][0];
				checkWinner += board[1][1];
				checkWinner += board[0][2];

				break;
			}
			
			//System.out.print("\nCheck Winner: " + checkWinner);
			
			if (checkWinner.equals("xxx")) {
				if (player1 == 'x') {return 1;}
				if (player2 == 'x') {return 2;}
				
			}else if (checkWinner.equals("ooo")) {
				//System.out.println("Player1: " + player1);
				//System.out.println("Player2: " + player2);

				if (player1 == 'o') {return 1;}
				if (player2 == 'o') {return 2;}
			}
	}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (board[i][j] != ' ') {
					filled++;}
				}
			}
				


		//System.out.println("Filled: " + filled);
		if (filled == 9) {
			winner= 0;}
		//System.out.println(winner);
		return winner;
		

}

	public static void main(String[] args) {
		/*
		 TicTacToeGame temp = new TicTacToeGame();
	      temp.executeMove("00x");
	      temp.executeMove("01o");
	      temp.executeMove("22x");
	      temp.executeMove("11o");
	      temp.executeMove("10x");
	      temp.executeMove("12o");
	      temp.executeMove("21x");
	      temp.executeMove("20o");
	      temp.executeMove("02x");
	      temp.determineWinner();
	      temp.gameOver();
	      */
	      
	}

}


