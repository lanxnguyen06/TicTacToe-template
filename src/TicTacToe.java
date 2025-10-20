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
        scanner = new Scanner(System.in);
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
                playAgain();
            } else if (gameBoard.isFull()) { // if it's true that the board is full
                gameEnded = true;
                gameBoard.printBoard();
                playAgain();
            } else {
                gameBoard.printBoard(); // if no one has won yet or the board isn't full keep playing
                promptPlayerMove();
                switchPlayers();
            }
        }
    }

    private void playAgain(){
        scanner = new Scanner(System.in);
        boolean checkAsk = false;
        while (!checkAsk){
            try{
                System.out.println("Want to play again?");
                String ask = scanner.nextLine();
                if (ask.equalsIgnoreCase("yes")){
                    checkAsk = true; // stop the loop
                    gameBoard = new GameBoard(); // reset the gameboard
                    currentPlayer = player1; // reset back to player 1
                    startGame();
                }
                else if (ask.equalsIgnoreCase("no")){
                    System.out.println("Thanks for playing!");
                    checkAsk = true;
                }
                else
                System.out.println("You must type 'yes' or 'no.'");
            }
            catch (InputMismatchException e){
                System.out.println("You must type 'yes' or 'no.'");
            }
        }
    }

    // Prompts the player to place a move and checks for its validity
    private void promptPlayerMove() {
        scanner = new Scanner(System.in);
        boolean select = false;
        int row = 0;
        int col = 0;
        while(!select){
            try{
                System.out.println("It's " + currentPlayer.getName() + "'s turn. Their symbol is " + currentPlayer.getSymbol());
                System.out.println("Place a move");
                System.out.println("Select a row (1-3)");
                row = scanner.nextInt();
                scanner.nextLine();
                if (row >= 1 && row <= 3){
                    select = true; // if input is valid, exit loop
                }
                else{
                    System.out.println("You must enter a row between the numbers 1-3.");
                }
            }
            catch (InputMismatchException e){
                System.out.println("This is not a valid number.");
                scanner.nextLine();
            }
        }

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
    if (!placeMove){ // if placeMove is not valid
        System.out.println("That spot is full, try again");
        promptPlayerMove();
        }
    }

    private void switchPlayers() {
        if (currentPlayer == player1)
            currentPlayer = player2;
        else
            currentPlayer = player1;
    }
}
