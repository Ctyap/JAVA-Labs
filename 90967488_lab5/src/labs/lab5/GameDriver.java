package labs.lab5;

import java.util.Scanner;

public class GameDriver {
	public static void main(String[] args) {
		System.out.println("Which game do you want to play?\nEnter 1 for Tic-Tac-Toe, 2 for Connect Four: ");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		GameEngine gamePlayer;
		if (option == 1) {
			gamePlayer = new GameEngine(new TicTacToeGame());
		} 
		else {
			gamePlayer = new GameEngine(new ConnectFourGame());
		}
		gamePlayer.play();
	}
}

/*
00x
02o
01x
10o
12x
11o
20x
21o
22x
*/