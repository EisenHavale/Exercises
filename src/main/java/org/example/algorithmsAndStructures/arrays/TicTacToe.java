package org.example.algorithmsAndStructures.arrays;

import java.util.Scanner;

/*
    Create a tic tac toe using arrays.
    The point is to create a two dimensions (3X3) array where once a user add a number It'll change the position for a
    symbol either x or o.

    A user can win if has Any row, diagonal or column.
    0 1 2
    3 4 5
    6 7 8

    Player interface:
    * Welcome message
    * Quick explanation and rules ( two players are needed)
    * CLI will be the interface

    * Welcome method will show the rules, and the welcome message.
    * hasWon will validate if anyone already won
    * addMove will capture the info and verify is valid
    * print will show how the game is going.


    After each play needs to verify:
     * Value submitted exists in the matrix
     * If value is not already filled
     * If any player won

     In any unexpected behavior needs to have a exception handler.
     * Out of bounds
     * User won
     * Wrong type submitted
     */
public class TicTacToe {
    private String[][] board = {{"0","1","2"}, {"3", "4", "5"}, {"6", "7", "8"}};
    private boolean isXTurn = false;

        public boolean hasWon(){
            return false;
        }

        public void welcome(){
            String WELCOME_MESSAGE = "Welcome to Eisen's tic tact toe.";
            String RULES ="""
                           Here are the rules to play:
                           1. Number of players allowed is 2
                           2. Every player can make only one movement on its turn
                           3. To play are used following symbols. First player o, second player x
                           4. To win needs to have 3 symbols in either a row, column or diagonal.
                           5. To do a movement need to add a number between 0 and 8
                           """;

            StringBuilder welcomeMessage = new StringBuilder();


            welcomeMessage.append(WELCOME_MESSAGE)
                            .append(RULES);

            System.out.println(welcomeMessage.toString());
            print();

            // Game starting point


        }

        public void addMovement(){
            String message = isXTurn ? "It's X turn" : "It's O Turn";
            System.out.print(message);

        }

        public void print(){
            for( int i = 0; i < 3; i++){
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    row.append(board[i][j]);
                }
                System.out.println(row);
            }
        }

        private void captureInfo(){
            Scanner input = new Scanner(System.in);
            input.nextInt();
        }

}
