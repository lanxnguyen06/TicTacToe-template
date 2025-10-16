/*
 * Created on 2025-10-06
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

import java.util.InputMismatchException;
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
        player1 = new Player(player1Name, 'X');
        player2 = new Player(player2Name, 'O'); 
        currentPlayer = player1;
    }

    public void startGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            if (gameBoard.checkWin()) { // if it's true player won the game 
                gameEnded = true;
                gameBoard.printBoard();
                switchPlayers(); // switch back to previous player (aka the winner)
                System.out.println(currentPlayer.getName() + " wins!");
            } else if (gameBoard.isFull()) { // if it's true that the board is full
                gameEnded = true;
                gameBoard.printBoard();
            } else {
                gameBoard.printBoard(); // if no one has won yet or the board isn't full keep playing
                promptPlayerMove();
                switchPlayers();
            }
        }
    }

    // Prompts the player to place a move and checks for its validity
    private void promptPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        boolean select = false;
        int row = 0;
        int col = 0;
        while(!select){
            try{
                System.out.println("It's " + currentPlayer.getName() + "s turn. Their symbol is " + currentPlayer.getSymbol());
                System.out.println("Place a move");
                System.out.println("Select a row (1-3)");
                row = scanner.nextInt();
                scanner.nextLine();
            if (row >= 1 && row <= 3){
                select = true;
            }
            else{
                System.out.println("You must enter a row between the numbers 1-3.");
            }
        }
            catch (InputMismatchException e){
                System.out.println("This is not a valid number.");
                scanner.nextLine();
            }
        }//ends while

        select = false; // reset for columns

        System.out.println("Select a column (1-3)");
        while(!select){
        try{
            col = scanner.nextInt();
            scanner.nextLine();
            if (col >= 1 && col <= 3){
                select = true;
            }
            else{
            System.out.println("You must enter a column between the numbers 1-3.");
            }
        }
        catch (InputMismatchException e){
            System.out.println("This is not a valid number.");
            select = false;
            scanner.nextLine();
        }
    }//ends while loop

    row = row - 1; // i ask user input from rows 1-3 because that's how humans count rows so i have to -1 to start from 0 index
    col = col - 1;

    boolean placeMove = gameBoard.makeMove(row, col, currentPlayer.getSymbol());
    if (!placeMove){
        System.out.println("That spot is full, try again");
        promptPlayerMove();
    }

    boolean validMove = false;
        // TODO: ask the player to place a move
        // Check whether the move is valid, if not, ask the player to place a move again
        // If the player's move is valid, the move is placed on the gameBoard
    }//ends while loop

    private void switchPlayers() {
        if (currentPlayer == player1)
            currentPlayer = player2;
        else
            currentPlayer = player1;
    }
}
