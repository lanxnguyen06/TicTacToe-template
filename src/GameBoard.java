/*
 * Created on 2025-10-06
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

public class GameBoard {
    private char[][] board; // char array instead of String because it's just X and O and -

    // 'final' means that SIZE is a constant and cannot be changed after initialization
    // Java convention: Constants in Java are written in all upper-case letters
    // The size indicates the gameboard size (3x3)
    public static final int SIZE = 3;

    public GameBoard(char[][] board) {
        this.board = board;
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                board[r][c] = '-';
            }//ends column counter
        }//ends row counter
    }

    // makeMove marks a non-empty cell with the respective symbol
    public boolean makeMove(int row, int col, char symbol) {
        while(true){
            if (board[row][col] == '-'){ // checks if row + column has an empty space
                board[row][col] = symbol; // replaces empty space with symbol
                return false; // exit loop
            }//ends if statement
            else
                System.out.println("There is already a symbol here.");
                return true; // continue loop
        }
    }//ends while loop
    // Checks if a player has placed three symbols in a row, column, or diagonal
    // If yes, that player has won
    
    public boolean checkWin() {
        // Hint: Define additional methods to keep your code organized and readable!
        // TODO: Check rows // rows at [0][0] [0][1] [0][2] and [1][0] [1][1] [1][2] and [2][0] [2][1] [2][2]
        
        // TODO: Check columns // columns at  [0][0] [1][0] [2][0] and [0][1] [1][1] [2][1] and [0][2] [1][2] [2][2]

        // TODO: Check diagonals // diagonals at [0][0] [1][1] [2][2] and [0][2] [1][1] [2][0]
        
        return false;
    }

    // Checks if the gameboard is full but no player won
    public boolean isFull() {
        int count = 0;
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if (board[r][c] == 'x' || board[r][c] == 'o'){
                    count++;
                }//ends if
            }//ends column counter
        }//ends row counter
        if (count == 9 && checkWin() == false){ // if count = 9 that means all the spaces are full
            System.out.println("The board is full and nobody won.");
        }//ends if
        return true;
    }

    public void printBoard() {
        // TODO: implement
        System.out.println("Should print out the game board's current status.");
    }
}
