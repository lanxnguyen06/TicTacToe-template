/*
 * Created on 2025-10-06
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

import java.util.Scanner;

public class TicTacToe {
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private String player1Name;
    private String player2Name;
    private Player currentPlayer;
    private Scanner scanner;

    public TicTacToe() {
        Scanner scanner = new Scanner(System.in);
        gameBoard = new GameBoard();
        System.out.println("Enter player 1's name. This player will use 'X'.");
        player1Name = scanner.nextLine();
        System.out.println("Enter player 2's name. This player will use 'O'.");
        player2Name = scanner.nextLine();
        Player player1 = new Player(player1Name, 'x');
        Player player2 = new Player(player2Name, 'o'); 
        startGame();
        // TODO: read player names
        // player1 starts the game
    }

    public void startGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            gameBoard.printBoard();
            promptPlayerMove();
            if (gameBoard.checkWin()) {
                gameBoard.printBoard();
                System.out.println(player1 + " wins!");
                gameEnded = true;
            } else if (gameBoard.isFull()) {
                gameBoard.printBoard();
                System.out.println("The game ended in a tie!");
                gameEnded = true;
            } else {
                switchPlayers();
            }
        }
        scanner.close();
    }

    // Prompts the player to place a move and checks for its validity
    private void promptPlayerMove() {
        boolean validMove = false;
        System.out.println("Place a move");
        // TODO: ask the player to place a move
        // Check whether the move is valid, if not, ask the player to place a move again
        // If the player's move is valid, the move is placed on the gameBoard
        while(validMove){
        if (!validMove) {
            System.out.println("Invalid move, try again.");
        }
    }//ends while loop

    }

    // Switch players
    // Sets the player that is not the currentPlayer as currentPlayer
    private void switchPlayers() {
        // TODO implement
    }
}
