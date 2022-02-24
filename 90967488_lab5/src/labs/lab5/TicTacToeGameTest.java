package labs.lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeGameTest {

	//This test checks for duplicates
	@Test
	void testIsValidMoveDup() {
		TicTacToeGame temp = new TicTacToeGame();
		assertEquals(temp.isValidMove("00x"),true);
		temp.executeMove("00x");
		assertEquals(temp.isValidMove("00o"),false);

	}
	
	@Test
	void testIsValidMoveIncorrectPiece() {
		TicTacToeGame temp = new TicTacToeGame();
		assertEquals(temp.isValidMove("00x"),true);
		temp.executeMove("00x");
		assertEquals(temp.isValidMove("01x"),false);
		assertEquals(temp.isValidMove("01o"),true);
	}
	
	@Test
	void testIsValidMove() {
		TicTacToeGame temp = new TicTacToeGame();
		assertEquals(temp.isValidMove("00x"),true);
		assertEquals(temp.isValidMove("01o"),true);
		assertEquals(temp.isValidMove("22x"),true);
		assertEquals(temp.isValidMove("11o"),true);
		assertEquals(temp.isValidMove("10x"),true);
		assertEquals(temp.isValidMove("12o"),true);
		assertEquals(temp.isValidMove("21x"),true);
		assertEquals(temp.isValidMove("20o"),true);
		assertEquals(temp.isValidMove("02x"),true);
	}
	
	@Test
	void testIsValidMoveWrongInputs() {
		TicTacToeGame temp = new TicTacToeGame();
		assertEquals(temp.isValidMove("00x"),true);
		assertEquals(temp.isValidMove("23x"),false);
		assertEquals(temp.isValidMove("32o"),false);
		assertEquals(temp.isValidMove("12313123"),false);
		assertEquals(temp.isValidMove("111"),false);
		assertEquals(temp.isValidMove("22w"),false);
		assertEquals(temp.isValidMove("12x   "),false);
		assertEquals(temp.isValidMove("12"),false);
	}

	 @Test
	 void testStartDisplay() {
		 TicTacToeGame temp = new TicTacToeGame();
	      String board = "   |   |   " + System.lineSeparator() +
	              "-----------" + System.lineSeparator() +
	              "   |   |   " + System.lineSeparator() +
	              "-----------" + System.lineSeparator() +
	              "   |   |   " + System.lineSeparator();
	      assertEquals(board, temp.displayBoard());
	 }
	 
	 
	 @Test
	 void testGameOverFullBoard() {
		 TicTacToeGame temp = new TicTacToeGame();
	      assertEquals(temp.gameOver(), false);
	      temp.executeMove("00x");
	      temp.executeMove("01o");
	      temp.executeMove("22x");
	      temp.executeMove("11o");
	      temp.executeMove("10x");
	      temp.executeMove("12o");
	      assertEquals(temp.gameOver(), false);
	      temp.executeMove("21x");
	      temp.executeMove("20o");
	      temp.executeMove("02x");
	      assertEquals(temp.gameOver(), true);
	 }
	 
	 @Test
	 void testPlayDisplay() {
		 TicTacToeGame temp = new TicTacToeGame();
	      String board = " x | o | x " + System.lineSeparator() +
	              "-----------" + System.lineSeparator() +
	              " x | o | o " + System.lineSeparator() +
	              "-----------" + System.lineSeparator() +
	              " o | x | x " + System.lineSeparator();
	      temp.executeMove("00x");
	      temp.executeMove("01o");
	      temp.executeMove("22x");
	      temp.executeMove("11o");
	      temp.executeMove("10x");
	      temp.executeMove("12o");
	      temp.executeMove("21x");
	      temp.executeMove("20o");
	      temp.executeMove("02x");
	      assertEquals(temp.gameOver(), true);
	      assertEquals(board, temp.displayBoard());
	 }
	 
	 @Test
	 void testPlayer1Wins() {
		 TicTacToeGame temp = new TicTacToeGame();
	      temp.executeMove("00x");
	      temp.executeMove("12o");
	      temp.executeMove("10x");
	      temp.executeMove("21o");
	      temp.executeMove("20x");
	      assertEquals(temp.gameOver(), true);
	      assertEquals(temp.determineWinner(), 1);
	 }
	 
	 @Test
	 void testPlayer2Wins() {
		 TicTacToeGame temp = new TicTacToeGame();
	      temp.executeMove("00x");
	      temp.executeMove("20o");
	      temp.executeMove("10x");
	      temp.executeMove("21o");
	      temp.executeMove("11x");
	      temp.executeMove("22o");
	      assertEquals(temp.gameOver(), true);
	      assertEquals(temp.determineWinner(), 2);
	 }
	 
	 @Test
	 void testPlayer1isX() {
		 TicTacToeGame temp = new TicTacToeGame();
	      temp.executeMove("00x");
	      temp.executeMove("12o");
	      temp.executeMove("10x");
	      temp.executeMove("21o");
	      temp.executeMove("20x");
	      assertEquals(temp.gameOver(), true);
	      assertEquals(temp.determineWinner(), 1);
	 }
	 
	 @Test
	 void testPlayer1isO() {
		 TicTacToeGame temp = new TicTacToeGame();
	      temp.executeMove("00o");
	      temp.executeMove("12x");
	      temp.executeMove("10o");
	      temp.executeMove("21x");
	      temp.executeMove("20o");
	      assertEquals(temp.gameOver(), true);
	      assertEquals(temp.determineWinner(), 1);
	 }
	 
	 @Test
	 void testDisplayUpdates() {
		 TicTacToeGame temp = new TicTacToeGame();
	      String board = " o |   |   " + System.lineSeparator() +
	              "-----------" + System.lineSeparator() +
	              "   |   | x " + System.lineSeparator() +
	              "-----------" + System.lineSeparator() +
	              "   |   |   " + System.lineSeparator();
	      temp.executeMove("00o");
	      temp.executeMove("12x");
	      assertEquals(board, temp.displayBoard());
	      temp.executeMove("10o");
	      temp.executeMove("21x");
	      temp.executeMove("20o");
	      board = " o |   |   " + System.lineSeparator() +
	              "-----------" + System.lineSeparator() +
	              " o |   | x " + System.lineSeparator() +
	              "-----------" + System.lineSeparator() +
	              " o | x |   " + System.lineSeparator();
	      assertEquals(board, temp.displayBoard());
	 }
	 
	 
}
