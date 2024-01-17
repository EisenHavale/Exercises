package org.example.algorithmsAndStructures.arrays;

import java.util.Objects;
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

    private Scanner input = new Scanner(System.in);

    private boolean hasWon = false;

        public boolean hasWon(){
            return false;
        }

        public void welcome(){
            String WELCOME_MESSAGE = "Welcome to Eisen's tic tact toe. \n";
            String RULES ="""
                           Here are the rules to play:
                           1. Number of players allowed is 2
                           2. Every player can make only one movement on its turn
                           3. To play are used following symbols. First player o, second player x
                           4. To win needs to have 3 symbols in either a row, column or diagonal.
                           5. To do a movement need to add a number between 0 and 8
                           6. Once a section is used by either symbol can't be replaced.
                           """;

            StringBuilder welcomeMessage = new StringBuilder();


            welcomeMessage.append(WELCOME_MESSAGE)
                            .append(RULES);

            System.out.println(WELCOME_MESSAGE);

            System.out.println("Tap enter once you ready to continue with the rules of the game");
            input.nextLine();

            System.out.println(RULES);

        }

        public void play(){
            welcome();
            int index = 0;
            while (!hasWon && index<8){
                addMovement();
                print();
                index++;
                hasAlreadyWon();
            }
        }

        public void addMovement(){
            String symbol = this.isXTurn ? "'X'": "'O'";

            String message = "It's " + symbol + " turn";
            System.out.print(message+"\n");
            print();
            int[] positions = captureInfo();

            this.board[positions[0]][positions[1]] = symbol;


            this.isXTurn = !this.isXTurn;
        }

        public void print(){
            for( int i = 0; i < 3; i++){
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < 3; j++) {
                    row.append("  ")
                            .append(board[i][j])
                            .append("  ");
                }
                System.out.println(row);
            }
        }

        private int[] captureInfo(){
            return translateInput(this.input.nextInt());
        }

        private int[] translateInput(int input){
            // Validate the value is not greater than 8 or smaller than 0;
            return new int[]{getRow(input), getColumn(input)};
        }

        private int getRow(int value) {
            if(value>2 && value<6){
                return 1;
            }
            if(value>5 && value <=8){
                return 2;
            }
            return 0;
        }
        private int getColumn(int value ){
            return switch (value) {
                case 0, 3, 6 -> 0;
                case 1, 4, 7 -> 1;
                default -> 2;
            };
        }
        private void hasAlreadyWon (){
           // Validate rows
            validateRows();
            validateColumns();
            validateDiagonals();

        }

        private void validateColumns( ) {
            if (Objects.equals(this.board[0][0], this.board[1][0]) && Objects.equals(this.board[0][0], this.board[2][0])) {
                this.hasWon = true;
                System.out.println("Player " + this.board[0][0] + " has won");
            }

            if (Objects.equals(this.board[0][1], this.board[1][1]) && Objects.equals(this.board[0][0], this.board[2][1])) {
                this.hasWon = true;
                System.out.println("Player " + this.board[0][1] + " has won");
            }

            if (Objects.equals(this.board[0][2], this.board[1][2]) && Objects.equals(this.board[0][0], this.board[2][2])) {
                this.hasWon = true;
                System.out.println("Player " + this.board[0][2] + " has won");
            }

        }

        private void validateRows(){
            if (Objects.equals(this.board[0][0], this.board[0][1]) && Objects.equals(this.board[0][0], this.board[0][2])) {
                this.hasWon = true;
                System.out.println("Player " + this.board[0][0] + " has won");
            }

            if (Objects.equals(this.board[1][0], this.board[1][1]) && Objects.equals(this.board[1][0], this.board[1][2])) {
                this.hasWon = true;
                System.out.println("Player " + this.board[1][0] + " has won");
            }

            if (Objects.equals(this.board[2][0], this.board[2][1]) && Objects.equals(this.board[2][0], this.board[2][2])) {
                this.hasWon = true;
                System.out.println("Player " + this.board[2][0] + " has won");
            }
        }

        private void validateDiagonals(){
            if (Objects.equals(this.board[0][0], this.board[1][1]) && Objects.equals(this.board[0][0], this.board[2][2])) {
                this.hasWon = true;
                System.out.println("Player " + this.board[0][0] + " has won");
            }

            if (Objects.equals(this.board[2][0], this.board[1][1]) && Objects.equals(this.board[2][0], this.board[0][2])) {
                this.hasWon = true;
                System.out.println("Player " + this.board[1][1] + " has won");
            }
        }
}
