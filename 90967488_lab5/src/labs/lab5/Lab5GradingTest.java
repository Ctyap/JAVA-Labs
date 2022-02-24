package labs.lab5;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class Lab5GradingTest {
    private String getElementFrom(Game game, int row, int col) {
        try {
            String[] rows = Arrays.stream(game.displayBoard()
                    .replaceAll("\r\n", "\n")
                    .split("\n"))
                    .filter(r -> !r.contains("---"))
                    .toArray(String[]::new);
            String[] elements = rows[row].split("\\|");
            return elements[col].trim();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid board setting: \n" + game.displayBoard());
        }
        return null;
    }

    @Timeout(10)
    @Test
    public void testTicTacToeGame_1() {
        Game game = new TicTacToeGame();

        assertFalse(game.gameOver());
        game.executeMove("22x");
        assertTrue(game.isValidMove("02o"));
        assertTrue(game.isValidMove("02o"));
        game.executeMove("02o");
        assertEquals("o", getElementFrom(game, 0, 2));
        game.executeMove("01x");
        game.executeMove("11o");
        game.executeMove("00x");
        game.executeMove("20o");
        assertTrue(game.gameOver());
        assertEquals(2, game.determineWinner());
    }

    @Test
    public void testTicTacToeGame_2() {
        Game game = new TicTacToeGame();
        assertEquals(0, game.determineWinner());
        assertFalse(game.isValidMove("aaa"));
        assertFalse(game.isValidMove("33x"));
        assertFalse(game.isValidMove("000"));

        game.executeMove("10x");
        assertFalse(game.isValidMove("11x")); // Same player play twice
        assertFalse(game.isValidMove("10o")); // Try to put on a taken place
        assertEquals("x", getElementFrom(game, 1, 0));
    }

    @Test
    public void testTicTacToeGame_3() {
        Game game = new TicTacToeGame();
        game.executeMove("10x");
        game.executeMove("00o");
        game.executeMove("11x");
        game.executeMove("12o");
        game.executeMove("02x");
        game.executeMove("20o");
        game.executeMove("01x");
        game.executeMove("21o");
        game.executeMove("22x");
        assertEquals(0, game.determineWinner());
        assertTrue(game.gameOver());
    }


    @Test
    public void testTicTacToeGame_4() {
        Game game = new TicTacToeGame();
        game.executeMove("11o");
        game.executeMove("11x"); // Invalid move
        game.executeMove("21o"); // Should be x's turn
        assertEquals("", getElementFrom(game, 2, 1));

        game.executeMove("21x");
        assertEquals("x", getElementFrom(game, 2, 1));
        assertFalse(game.isValidMove("22x"));
    }

    @Test
    public void testTicTacToeGame_5() {
        Game game = new TicTacToeGame();
        game.executeMove("00x");
        game.executeMove("10o");
        game.executeMove("20o"); // Invalid move
        assertEquals("", getElementFrom(game, 2, 0));
        game.executeMove("01x");
        game.executeMove("11o");
        game.executeMove("02x");

        assertTrue(game.gameOver());
    }


    @Test
    public void testConnectFourGame_1() {
        Game game = new ConnectFourGame();
        assertFalse(game.gameOver());
        assertEquals(0, game.determineWinner());

        game.executeMove("1r");
        game.executeMove("1y");
        game.executeMove("2r");
        game.executeMove("1y");
        game.executeMove("3r");
        game.executeMove("1y");
        game.executeMove("2r");
        game.executeMove("1y");

        assertEquals("r", getElementFrom(game, 4, 2));
        assertEquals("y", getElementFrom(game, 1, 1));
        assertEquals(2, game.determineWinner());
        assertTrue(game.gameOver());


    }

    @Test
    public void testConnectFourGame_2() {
        Game game = new ConnectFourGame();
        assertFalse(game.isValidMove("10x"));
        assertFalse(game.isValidMove("07r"));
        assertFalse(game.isValidMove("00x"));
        assertFalse(game.isValidMove("rr"));
        assertFalse(game.isValidMove("3a"));

        assertTrue(game.isValidMove("1r"));
        assertTrue(game.isValidMove("2y"));
        game.executeMove("2y");
        assertFalse(game.isValidMove("3y"));

    }

    @Test
    public void testConnectFourGame_3() {
        Game game = new ConnectFourGame();

        game.executeMove("0r");
        game.executeMove("0y");
        game.executeMove("1r");
        game.executeMove("1y");
        game.executeMove("3r");
        game.executeMove("2y");
        game.executeMove("3r");

        assertEquals("r", getElementFrom(game, 5, 3));
        assertEquals("y", getElementFrom(game, 5, 2));
    }

    @Test
    public void testConnectFourGame_4() {
        Game game = new ConnectFourGame();
        game.executeMove("1r");
        game.executeMove("1y");
        game.executeMove("1r");
        game.executeMove("1y");
        game.executeMove("1r");
        game.executeMove("1y");

        assertFalse(game.isValidMove("1r"));
        game.executeMove("2r");
        assertFalse(game.isValidMove("1y"));
    }

    @Test
    public void testConnectFourGame_5() {
        Game game = new ConnectFourGame();

        game.executeMove("2y");
        game.executeMove("2y");
        game.executeMove("2y");
        game.executeMove("2y");
        game.executeMove("2y");
        game.executeMove("2y");
        game.executeMove("2y");
        assertEquals("", getElementFrom(game, 4, 2));
        assertTrue(game.isValidMove("2r"));

        game.executeMove("2r");
        assertEquals("r", getElementFrom(game, 4, 2));
    }
}
