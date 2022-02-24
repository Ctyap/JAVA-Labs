package labs.lab5;


public class ConnectFourGame implements Game {
	private char player1, player2;
	private int firstMove = 0;
	private int _firstMove = 0;
	private int moveTurn = 0;
	private int filled = 0;
	private int winner = 0;
	
	char[][] board = new char[][]{
		  {' ',' ',' ',' ',' ',' ',' '},
		  {' ',' ',' ',' ',' ',' ',' '},
		  {' ',' ',' ',' ',' ',' ',' '},
		  {' ',' ',' ',' ',' ',' ',' '},
		  {' ',' ',' ',' ',' ',' ',' '},
		  {' ',' ',' ',' ',' ',' ',' '},

	};
	final int HEIGHT = board.length;
	final int WIDTH = board[0].length;

	String boardDisplay = "";
	
	
	public boolean isValidMove(String move) {
		
		//Player move must be two characters
		if (move.length() != 2) {return false;}
		//System.out.println("Move passes Length being 2.");
		
		//Player move first character must be an int
		if (Character.isDigit(move.charAt(0)) == false) {return false;}
		//System.out.println("Move passes first char being numeric.");

		
		//Player move first character (chute column) must be between 0 and 6
		int chute = Integer.parseInt(String.valueOf(move.charAt(0)));
		if (!(chute >= 0 && chute <= 6)) {return false;}
		//System.out.println("Move passes chute being between 0 and 6.");

		
		//Checks if chute is full
		if (board[0][chute] != ' ') {return false;}
		//System.out.println("Move passes that chute isnt full.");

		
		//Player move second character must be a char of 'r' or 'y'
		char playerSymbol = move.charAt(1);
		if (playerSymbol == 'r' || playerSymbol == 'y') {}else {return false;}
		//System.out.println("Move passes that playerSymbol is either r or y.");

		
		//Initiates player1 and player2 by symbol.
		//System.out.println("moveTurn: " + moveTurn);
		//System.out.println("PlayerSymbol: " + playerSymbol);

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
		
		//System.out.println("player1 = " + player1);
		//System.out.println("player2 = " + player2);

		
		//Makes sure same player doesnt go twice checking player symbol.
		if (moveTurn == 0) {
			if (player1 != playerSymbol) {
				//System.out.println("player1 != " + playerSymbol);
				moveTurn=0;
				return false;}
			else{moveTurn=1;}
			
		}else if (moveTurn == 1) {
			if (player2 != playerSymbol) {
				//System.out.println("player1 != " + playerSymbol);
				moveTurn=1;
				return false;}
			else{moveTurn=0;}
		}return true;
	}

	
	public void executeMove(String move) {
		//System.out.println("Enters executeMove method.");

		int chute = Integer.parseInt(String.valueOf(move.charAt(0)));
		char playerSymbol = move.charAt(1);
		
		if (_firstMove == 0){
			player1 = playerSymbol;
			_firstMove++;}
	
		else if (_firstMove == 1) {
				player2 = playerSymbol;
				_firstMove++;
			}
		

		for (int row = HEIGHT-1; row >= 0; row--){
			if(board[row][chute] == ' '){
				board[row][chute] = playerSymbol;
				break;
			}
		}
		//System.out.println("Leaves executeMove method.");

	}

	public boolean gameOver() {
		//System.out.println("Passed filled.");
		if (this.determineWinner() == 1 ||this.determineWinner() == 2 || this.determineWinner() == 121 || this.determineWinner() == 5) {
			//System.out.println("true");
			return true;
		}//System.out.println("false");
		return false;
	}
	
	
	public String displayBoard() {
		boardDisplay ="";
	
		outerloop:
		for (int row = 0; row < HEIGHT; row++) {
			boardDisplay += ' ';
			for (int col = 0; col < WIDTH; col++) {
				boardDisplay += board[row][col];
				if (col == board[0].length -1) {boardDisplay += ' ';}else
				boardDisplay += " | ";
			}
			if (row == HEIGHT - 1) {break outerloop;}else
			boardDisplay += System.lineSeparator();
			boardDisplay += "---------------------------";

			boardDisplay += System.lineSeparator();

		}
		return boardDisplay += System.lineSeparator();
	}
	
		
	
	public int determineWinner() {
		int winner = 3;
		
		for(int row = 0; row < HEIGHT; row++) {
			for(int col = 0; col < WIDTH; col++) {
				int player = board[row][col];
				if (player == ' ') {continue;}
				
				//System.out.println("COL: " + col);
				//System.out.println("ROW: " + row);
				
					//If 3 slots are open to right of symbol, we check horizontal right, diagonal up right.
					if (col + 3 < WIDTH) {
						//System.out.println("Checks horizontal");
						//Checks if 3 slots to the right match.
						if (player == board[row][col + 1] && player == board[row][col + 2] && player == board[row][col + 3])
						{winner = player;}
					}
					
					//Checks if 3 rows above are available.
					
					if (row + 3 > HEIGHT) {
						//System.out.println("Row: " + row);
						//System.out.println("Col: " + col);
						
						//Checks for vertical matches
		                if (player == board[row-1][col] && player == board[row-2][col] && player == board[row-3][col])
		                    winner = player;
		                
		                //Checks if 3 columns to right are available
		                if (col + 3 < WIDTH) {
		                	
		                	//Checks for up right diagonal matches.
			                if (player == board[row-1][col+1] && player == board[row-2][col+2] && player == board[row-3][col+3])
				                    winner = player;}
		             
		                //Checks if 3 columns to the left are available.
		                if (col - 3 >= 0) {
			                if (player == board[row-1][col-1] && player == board[row-2][col-2] && player == board[row-3][col-3])
				                    winner = player;}
		                }
		                
					}
		
		//Assigns and returns the correct winner according to player symbol
		}if (winner == player1) {winner = 1;}
		if  (winner == player2) {winner = 2;}
		if (winner == 3) {winner = 0;}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (board[i][j] != ' ') {
					filled++;}
				}
			}
		
		if (filled == 42) {
			winner= 5;}
		//Assigns if match is a draw
		//System.out.println("Winner: " + winner);
		return winner;
	}

	
	public static void main(String[] args) {
		//GameDriver game = new GameDriver();
		//ConnectFourGame game = new ConnectFourGame();
        //game.executeMove("3y");
       // game.executeMove("4r");
       // System.out.println(game.determineWinner());
		//game.main(args);
		
		/*
	       Game game = new ConnectFourGame();
	        game.executeMove("0y");
	        game.executeMove("0r");
	        game.executeMove("1y");
	        game.executeMove("1r");
	        game.executeMove("2y");
	        game.executeMove("2r");
	        game.executeMove("3y");

	       */
	       Game game = new ConnectFourGame();

	        game.executeMove("0y");
	        game.executeMove("1r");
	        game.executeMove("1y");
	        game.executeMove("2r");
	        game.executeMove("2y");
	        game.executeMove("3r");
	        game.executeMove("2y");
	        game.executeMove("3r");
	        game.executeMove("3y");
	        game.executeMove("4r");
	        game.executeMove("3y");
	      System.out.println(  game.displayBoard());

	        
	        game.gameOver();
	        
	        
	        
	        
	}
}

						


