package com.sample;

import java.util.Scanner;
public class TicTacToeGame {

	    // Define the game board as a 3x3 array
	    private static char[][] board = {
	            {' ', ' ', ' '},
	            {' ', ' ', ' '},
	            {' ', ' ', ' '}
	    };

	    // Define the current player (X or O)
	    private static char currentPlayer = 'X';

	    // Create a Scanner object for user input
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        // Start the game loop
	        while (true) {
	            // Display the current state of the board
	            printBoard();

	            // Get the player's move
	            int[] move = getPlayerMove();

	            // Update the board with the player's move
	            updateBoard(move);

	            // Check if the current player wins
	            if (checkWin()) {
	                printBoard();
	                System.out.println("Player " + currentPlayer + " wins!");
	                break;
	            }

	            // Check if the board is full (draw)
	            if (isBoardFull()) {
	                printBoard();
	                System.out.println("The game is a draw!");
	                break;
	            }

	            // Switch to the other player for the next turn
	            switchPlayer();
	        }

	        // Close the scanner
	        scanner.close();
	    }

	    // Method to print the current state of the board
	    private static void printBoard() {
	        System.out.println("-------------");
	        for (int i = 0; i < 3; i++) {
	            System.out.print("| ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j] + " | ");
	            }
	            System.out.println();
	            System.out.println("-------------");
	        }
	    }

	    // Method to get the player's move
	    private static int[] getPlayerMove() {
	        int[] move = new int[2];

	        // Prompt the current player for their move
	        System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
	        move[0] = scanner.nextInt();
	        move[1] = scanner.nextInt();

	        return move;
	    }

	    // Method to update the board with the player's move
	    private static void updateBoard(int[] move) {
	        int row = move[0];
	        int col = move[1];

	        // Check if the chosen cell is empty
	        if (board[row][col] == ' ') {
	            // Update the board with the player's symbol
	            board[row][col] = currentPlayer;
	        } else {
	            // The cell is already occupied, prompt the player to choose another move
	            System.out.println("Cell already occupied. Choose another move.");
	            int[] newMove = getPlayerMove();
	            updateBoard(newMove);
	        }
	    }

	    // Method to check if the current player wins
	    private static boolean checkWin() {
	        // Check rows, columns, and diagonals for a winning combination
	        return (checkRows() || checkColumns() || checkDiagonals());
	    }

	    // Helper method to check rows for a winning combination
	    private static boolean checkRows() {
	        for (int i = 0; i < 3; i++) {
	            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
	                return true;
	            }
	        }
	        return false;
	    }

	    // Helper method to check columns for a winning combination
	    private static boolean checkColumns() {
	        for (int i = 0; i < 3; i++) {
	            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
	                return true;
	            }
	        }
	        return false;
	    }

	    // Helper method to check diagonals for a winning combination
	    private static boolean checkDiagonals() {
	        return ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
	                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer));
	    }

	    // Method to check if the board is full (draw)
	    private static boolean isBoardFull() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (board[i][j] == ' ') {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    // Method to switch to the other player
	    private static void switchPlayer() {
	        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	    }
	}

