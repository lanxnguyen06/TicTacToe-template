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

    public GameBoard() {
        board = new char[SIZE][SIZE];
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                board[r][c] = '-';
            }//ends column counter
        }//ends row counter
    }

    // makeMove marks a non-empty cell with the respective symbol
    public boolean makeMove(int row, int col, char symbol){
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE){
                System.out.println("Invalid position");
                return false;
            }

            if (board[row][col] == '-'){ // checks if row + column has an empty space
                board[row][col] = symbol; // replaces empty space with symbol
                return true; // exit loop
            }//ends if statement

            else{
                System.out.println("There is already a symbol here.");
                return false; // continue loop
            }
        }
    // Checks if a player has placed three symbols in a row, column, or diagonal
    // If yes, that player has won

    public boolean checkRows(){ // pattern of rows incrementing by 1
        for (int r = 0; r < SIZE; r++){
            if (board[r][0] != '-' && board[r][0] == board[r][1] && board[r][1] == board[r][2]){
                return true;
            }
        }
        return false;
    }
    public boolean checkColumns(){ // pattern of columns incrementing by 1
        for (int c = 0; c < SIZE; c++){
            if (board[0][c] != '-' && board[0][c] == board[1][c] && board[1][c] == board[2][c]){
                return true;
            }
        }
        return false;
    }
    public boolean checkDiagonals(){
        if (board[1][1] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        else if (board[1][1] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) // just check one of the elements if empty space because && will check if they all have same char anyway
            return true;
        else
            return false;
    }
    
    public boolean checkWin(){
        if (checkRows() == true || checkColumns() == true || checkDiagonals() == true)
            return true;
        else
            return false;
    }

    // Checks if the gameboard is full but no player won
    public boolean isFull() {
        int count = 0;
        for (int r = 0; r < SIZE; r++){
            for (int c = 0; c < SIZE; c++){
                if (board[r][c] == 'x' || board[r][c] == 'o'){
                    count++;
                }//ends if
            }//ends column counter
        }//ends row counter
        if (count == 9 && checkWin() == false){ // if count = 9 that means all the spaces are full
            System.out.println("The board is full and nobody won.");
            return false;
        }//ends if
        return true;
    }

    public void printBoard() {
        System.out.println("--------------");
        for (int r = 0; r < SIZE; r ++){
            System.out.print("| ");
            for (int c = 0; c < SIZE; c++){
                System.out.print(board[r][c] + " | ");
            }
            System.out.println();
            System.out.println("--------------");
        }
    }
}
